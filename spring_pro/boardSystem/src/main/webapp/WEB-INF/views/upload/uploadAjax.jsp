<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp" %>

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

<div class="bigPictureWrapper">
    <div class="bigPicture">

    </div>
</div>

<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple>
</div>
<div class="uploadResult">
    <ul></ul>
</div>
<button id="uploadBtn">file upload</button>


<script>
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

    var cloneObj = $(".uploadDiv").clone();
    $("#uploadBtn").click(function () {
        var formData = new FormData();
        var inputFile = $("input[name='uploadFile']");
        var files = inputFile[0].files;
        console.log(files);

        for (var i = 0; i < files.length; i++) {
            if (checkExtension(files[i].name, files[i].size)) {
                formData.append("uploadFile", files[i]);
            }
        }

        $.ajax({
            url: "/upload/uploadAjax",
            type: "POST",
            processData: false,
            contentType: false,
            data: formData,
            dataType: "json",
            cache: false,
            contentType: false,
            processData: false
        }).done(function (result) {
            alert("파일업로드 성공");
            console.log(result);
            showUploadFile(result);
            $(".uploadDiv").html(cloneObj.html())

        }).fail(function (xhr, status, error) {
            alert("파일 업로드 실패: " + error);
            console.log(xhr);
            console.log(status);
            console.log(error);
        });
    });


    var uploadResult = $(".uploadResult");

    function showUploadFile(uploadResultArr) {
        var str = "";
        $(uploadResultArr).each(function (i, obj) { // each : 한개씩 꺼내와서 처리.
            if (!obj.image) {
                // 일반파일 표시형식
                var fileCallPath = encodeURIComponent(obj.uploadpath + "/"
                    + obj.uuid + "_" + obj.filename);
                var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");

                str += "<li><div><a href='/download?fileName=" + fileCallPath + "'>" +
                    "<img src='/resources/img/attach.png'>" + obj.filename + "</a>" +
                    "<span data-file=\'" + fileCallPath + "\' data-type='file'> x </span>" +
                    "</div></li>";
            } else {
                //이미지 파일 표시형식
                var fileCallPath = encodeURIComponent(obj.uploadpath +
                    "/s_" + obj.uuid + "_" + obj.filename);
                var originPath = obj.uploadpath + "\\" + obj.uuid + "_" + obj.filename;

                str += "<li><a href=\"javascript:showImage(\'" + originPath + "\')\">" +
                    "<img src='display?fileName=" + fileCallPath + "'></a>" +
                    "<span data-file=\'" + fileCallPath + "\' data-type='image'> x </span>" +
                    "<li>";
            }
        });

        uploadResult.append(str);
    }

</script>

<%@include file="../includes/footer.jsp" %>