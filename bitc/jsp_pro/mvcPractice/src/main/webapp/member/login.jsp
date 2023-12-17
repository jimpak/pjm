<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        span {
            color: red;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<span>
    <c:out value="${empty loginErrMsg ? '' : loginErrMsg}" />
</span>
<c:choose>
    <c:when test="${empty userId}">
        <script>
            function validateForm(form) {
                if (!form.user_id.value) {
                    alert("아이디를 입력하세요");
                    return false;
                }
                if (!form.user_pw.value) {
                    alert("비밀번호를 입력하세요");
                    return false;
                }
            }
        </script>
        <form action="/member/login.do" method="post" name="loginFrm"
              onsubmit="return validateForm(this);" class="mt-3">
            <div class="form-group">
                <label name="user_id">아이디:</label>
                <input type="text" class="form-control" name="user_id">
            </div>
            <div class="form-group">
                <label name="user_pw">패스워드:</label>
                <input type="password" class="form-control" name="user_pw">
            </div>
            <button type="submit" class="btn btn-primary">로그인하기</button>
        </form>
    </c:when>

    <c:otherwise>
        <div class="mt-3">${userName} 회원님, 로그인하셨습니다.</div>
        <a href="/member/logout.do" class="btn btn-secondary mt-2">로그아웃</a>
    </c:otherwise>
</c:choose>
</body>
</html>
