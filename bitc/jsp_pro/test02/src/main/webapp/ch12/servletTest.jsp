<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${msg}</h2>
<h2>Servlet Post</h2>
<form action="/servlet/test.do" method="post">
    <button type="submit">요청</button>
</form>

<h2>Servlet Get</h2>
<a href="/servlet/test.do">요청</a>
</body>
</html>
