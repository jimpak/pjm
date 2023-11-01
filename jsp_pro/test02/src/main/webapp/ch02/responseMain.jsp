<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>responseMain</title>
</head>
<body>
<h2>1. 로그인 폼</h2>
<%
    String loginErr = request.getParameter("loginErr");
    if(loginErr != null)
        out.print("로그인 실패");
%>
    <form action="./responseLogin.jsp" method="post">
        아이디 : <input type="text" name="user_id"><br>
        비밀번호 : <input type="text" name="user_pw"><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
