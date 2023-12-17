<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("pAttr", "김유신");
    request.setAttribute("rAttr", "계백");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>액션태그를 이용하여 포워딩</h2>
<jsp:forward page="/ch07/forwardSub.jsp"></jsp:forward>
</body>
</html>
