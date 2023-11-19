<%@ page import="common.JDBConnect" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    JDBConnect jdbc = new JDBConnect();
    jdbc.close();
%>
</body>
</html>
