<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
</head>
<body>
<h2>1개의 파일 업로드</h2>
<form action="/upload/uploadAction" method="post" enctype="multipart/form-data">
    <input type="file" name="ofile">
    <button type="submit">Submit</button>
</form>
<h2>여러파일 업로드</h2>
<form action="/upload/uploadActions" method="post" enctype="multipart/form-data">
    <input type="file" name="ofiles" multiple>
    <button type="submit">Submit</button>
</form>

<input type="file" name="ofile">
<button type="button" id="uploadBtn">파일업로드</button>


<script>
    $(document).ready(function () {
        $("uploadBtn").click(function (e) {
            var formData = new formData;
            var inputFile = $("input[name='ofile']")
            var files = inputFile[0].files
            console.log(files)
        });
    });
</script>
</body>
</html>