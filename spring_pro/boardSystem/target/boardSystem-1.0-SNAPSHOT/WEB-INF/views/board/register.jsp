<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<style>
    .uploadResult {
        width: 100%;
        background-color: grey;
    }

    .uploadResult ul {
        display: flex;
        flex-flow: row;
        justify-content: center;
        align-items: center;
    }

    .uploadResult ul li {
        list-style: none;
        padding: 10px;
    }

    .uploadResult ul li img {
        width: 100px;
    }

    .bigPictureWrapper {
        position: absolute;
        display: none;
        justify-content: center;
        align-items: center;
        top: 0%;
        width: 100%;
        height: 100%;
        background-color: grey;
        z-index: 100;
    }

    .bigPicture {
        position: relative;
        justify-content: center;
        align-items: center;
    }
</style>

<div class="container mt-3">
    <h2>게시물 등록 페이지</h2>
    <p>${error}<br>
    <p>
    <form action="/board/register" method="post">
        <div class="mb-3 mt-3">
            <label for="title" class="form-label">Title:</label>
            <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
        </div>
        <label for="content">Content:</label>
        <textarea class="form-control" rows="5" id="content" name="content"></textarea>
        <div class="mb-3">
            <label for="writer" class="form-label">Writer:</label>
            <input type="text" class="form-control" id="writer" value="${member.username}" name="writer" readonly>
        </div>
        <div class="mb-3">
            <label class="form-date-label">PostDate:</label>
            <input class="form-date-input" type="date" name="postdate">
        </div>
        <div class="from-group uploadDiv mb-3">
            <label class="form-file-label">File Upload:</label>
            <input class="form-file-input" type="file" name="uploadFile">
        </div>
        <div class="from-group uploadResult mb-3">
            <ul></ul>
        </div>

        <button type="submit" id="registerBtn" class="btn btn-primary">Register</button>
        <button type="reset" class="btn btn-secondary">Reset</button>
    </form>
</div>

<script>
    var formObj = $("form");
    document.querySelector("#registerBtn").addEventListener("click", function (e) {
        e.preventDefault();
        console.log("submit click");
        var str = "";

        $(".uploadResult ul li").each(function (i, obj) {
            var jobj = $(obj);
            console.log(jobj);

            console.log(obj);
            console.log("-------------------");
            console.log(jobj.data("filename"));

            str += "<input type='hidden' name='attachVOList[" + i + "].filename' value='" + jobj.data("filename") + "'>";
            str += "<input type='hidden' name='attachVOList[" + i + "].uuid' value='" + jobj.data("uuid") + "'>";
            str += "<input type='hidden' name='attachVOList[" + i + "].uploadpath' value='" + jobj.data("path") + "'>";
            str += "<input type='hidden' name='attachVOList[" + i + "].filetype' value='" + jobj.data("type") + "'>";
            console.log(str);
            formObj.append(str).submit();
        });
    })

    // Reguler Expressing (정규 표현식)
    var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
    var maxSize = 5242880; // 5MB

    function checkExtension(fileName, fileSize) {
        if (fileSize >= maxSize) {
            alert("파일 사이즈 초과");
            return false;
        }
        if (regex.test(fileName)) {
            alert("해당 종류의 파일은 업로드할 수 없습니다.");
            return false;
        }

        return true;
    }

    // 파일타입 내용이 바뀌면.
    $("input[type='file']").change(function () {
        var formData = new FormData();
        var inputFile = $("input[name='uploadFile']");
        var files = inputFile[0].files;

        console.log(files); // 파일이 존재하는지 확인

        for (var i = 0; i < files.length; i++) {
            if (!checkExtension(files[i].name, files[i].size)) {
                return false;
            }
            formData.append("uploadFile", files[i]);
        }

        $.ajax({
            url: '/upload/uploadAjax',
            type: 'POST',
            data: formData,
            dataType: 'json',
            processData: false,
            contentType: false,
        }).done(function (result) {
            // 성공적인 응답 처리
            alert("파일업로드 성공");
            console.log(result);
            showUploadFile(result);
            $(".uploadDiv").html(cloneObj.html());
        }).fail(function (xhr, status, error) {
            // 에러 처리
            console.log("Ajax request failed: " + error);
            console.log(xhr);
            console.log(status);
        });
    });

    function showUploadFile(uploadResultArr) {
        if (!uploadResultArr || uploadResultArr.length == 0) {
            return;
        }
        var uploadUL = $(".uploadResult ul");
        var str = "";
        $(uploadResultArr).each(function (i, obj) {
            if (obj.image) {
                var fileCallPath = encodeURIComponent(obj.uploadpath + "/s_" + obj.uuid + "_" + obj.filename);
                str += "<li data-path='" + obj.uploadpath + "'";
                str += " data-uuid='" + obj.uuid + "' data-filename='" + obj.filename + "' data-type='" + obj.image + "'"
                str += " ><div>";
                str += "<span> " + obj.filename + "</span>";
                str += "<button type='button' data-file=\'" + fileCallPath + "\' "
                str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
                str += "<img src='/upload/display?fileName=" + fileCallPath + "'>";
                str += "</div>";
                str += "</li>";
            } else {
                var fileCallPath = encodeURIComponent(obj.uploadpath + "/" + obj.uuid + "_" + obj.filename);
                var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");

                str += "<li "
                str += "data-path='" + obj.uploadpath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.filename + "' data-type='" + obj.image + "' ><div>";
                str += "<span> " + obj.filename + "</span>";
                str += "<button type='button' data-file=\'" + fileCallPath + "\' data-type='file' "
                str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
                str += "<img src='/resources/img/attach.png'></a>";
                str += "</div>";
                str += "</li>";
            }
        });
        uploadUL.append(str);
    }

    $(".uploadResult").on("click", "button", function (e) {
        console.log("delete file");
        var targetFile = $(this).data("file");
        var type = $(this).data("type");
        var targetLi = $(this).closest("li");

        $.ajax({
            url: '/upload/deleteFile',
            data: {fileName: targetFile, type: type},
            dataType: 'text',
            type: 'POST',
            success: function (result) {
                alert(result);
                targetLi.remove();
            }
        })
    });

</script>


<%@ include file="../includes/footer.jsp" %>