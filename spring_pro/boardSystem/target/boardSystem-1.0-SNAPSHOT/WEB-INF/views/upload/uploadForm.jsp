<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload/uploadForm" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile" multiple>
    <button>파일업로드</button>
</form>
</body>
</html>
