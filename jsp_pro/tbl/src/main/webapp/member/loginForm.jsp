<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red; font-size: 1.2em">
    <c:out value="${empty loginErrMsg ? '' : loginErrMsg}" />
</span>
<c:choose>
    <c:when test="${empty userId}">
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
        <form action="loginProcess.jsp" mothod="post name="loginFrm"
              onsubmit="return validateForm(this);">
            아이디 : <input type="text" name="user_id"><br>
            패스워드 : <input type="password" name="user_pw"><br>
            <input type="submit" value="로그인하기">
        </form>
    </c:when>

    <c:otherwise>
    ${userName} 회원님, 로그인하셨습니다.<br>
    <a href="logout.jsp">[로그아웃]</a>
    </c:otherwise>
</c:choose>
</body>
</html>
