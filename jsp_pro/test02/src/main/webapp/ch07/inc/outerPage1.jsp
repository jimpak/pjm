<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>외부 파일 1</h2>
<%
    String newVar1 = "외부파일1 변수";
%>
<ul>
    <li>page 영역 속성 : <%=pageContext.getAttribute("pAttr")%></li>
    <li>request 영역 속성 : <%=request.getAttribute("rAttr")%></li>
</ul>
</body>
</html>
