<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(session.getAttribute("userId") == null){
        //로그아웃상태
%>
<script>
    function validateForm(form) {
        if(!form.user_id.value){
            alert("아이디를 입력하세요");
            return false;
        }
        if(!form.user_pw.value) {
            alert("비밀번호를 입력하세요");
            return false;
        }
    }
</script>
<form action="loginProcess.jsp" mothod="post" name="loginFrm"
      onsubmit="return validateForm(this);">
    아이디 : <input type="text" name="user_id"><br>
    패스워드 : <input type="password" name="user_pw"><br>
    <input type="submit" value="로그인하기">
</form>
<%
    } else { // 로그인된 상태
%>
<%=session.getAttribute("userName")%> 회원님, 로그인하셨습니다.<br>
<a href="logout.jsp">[로그아웃]</a>
<%
    }
%>
</body>
</html>
