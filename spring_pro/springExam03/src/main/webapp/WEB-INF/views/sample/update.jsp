<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/sample/update">
    <input type="hidden" name="idx" value="${sample.idx}">
    이름 : <input type="text" name="name" value="${sample.name}"><br>
    나이 : <input type="text" name="age" value="${sample.age}"><br>
    연락처 : <input type="text" name="phone" value="${sample.phone}"><br>
    등록일 : <input type="text" name="postdate" value="${sample.postdate} disabled"><br>
    <input type="submit" value="수정"><br>
</form>
</body>
</html>
