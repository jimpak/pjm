<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>액션태그로 폼값 한번에 받기</h3>
<jsp:useBean id="person" class="common.Person"></jsp:useBean>
<jsp:setProperty name="person" property="*"></jsp:setProperty>
<ul>
    <li> 이름 : <jsp:getProperty name="person" property="name"/></li>
    <li> 나이 : <jsp:getProperty name="person" property="age"/></li>
</ul>
</body>
</html>
