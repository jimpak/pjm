<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>다른 페이지에서 쿠키 확인하기</h2>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for(int i = 0; i < cookies.length; i++) {
            String cookieName = cookies[i].getName();
            String cookieValue = cookies[i].getValue();
            out.println(cookieName + " : " + cookieValue);
        }
    }
%>
</body>
</html>
