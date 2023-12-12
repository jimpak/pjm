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

        console.log(files); // 파일이 존재하는지 확인

        for (var i = 0; i < files.length; i++) {
            if (checkExtension(files[i].name, files[i].size)) {
                formData.append("uploadFile", files[i]);
            }
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
    })


    var uploadResult = $(".uploadResult ul");

    function showUploadFile(uploadResultArr){
        var str="";
        $(uploadResultArr).each(function (i, obj){
            if(!obj.image) {
                // 일반파일 표시형식
                var fileCallPath =  encodeURIComponent( obj.uploadpath+"/"+ obj.uuid +"_"+obj.filename);

                var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");

                str += "<li><a href='/upload/download?fileName="+fileCallPath+"'>"+
                    "<img src='/resources/img/attach.png'>"+obj.filename+"</a>"+
                    "<span data-file=\'"+fileCallPath+"\' data-type='file'> x </span>"+
                    "</li>"
            }else{
                var fileCallPath =  encodeURIComponent( obj.uploadpath+ "/s_"+obj.uuid +"_"+obj.filename);

                var originPath = obj.uploadpath+ "\\"+obj.uuid +"_"+obj.filename;

                originPath = originPath.replace(new RegExp(/\\/g),"/");

                str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\">"+
                    "<img src='display?fileName="+fileCallPath+"'></a>"+
                    "<span data-file=\'"+fileCallPath+"\' data-type='image'> x </span>"+
                    "<li>";
            }
        });
        uploadResult.append(str);
    }

    function showImage(fileCallPath) {
        console.log("=================");
        console.log(fileCallPath);

        $(".bigPictureWrapper").css("display", "flex").show();
        $(".bigPicture")
            .html("<img src='display?fileName=" + fileCallPath + "'>")
            .animate({width: '100%', height: '100%'}, 1000);
    }

    $(".bigPictureWrapper").on("click", function () {
        $(".bigPicture").animate({width: '0%', height: '0%'}, 1000);
        setTimeout(function () {
            $(".bigPicture").hide();
        }, 1000);
    });


</script>

<%@include file="../includes/footer.jsp" %>