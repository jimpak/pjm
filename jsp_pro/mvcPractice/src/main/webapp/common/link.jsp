<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>메뉴</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .navbar {
            background-color: #f8f9fa;
        }

        .navbar-brand {
            color: #007bff;
        }

        .navbar-nav {
            margin-left: auto;
        }

        .nav-item {
            margin-right: 15px;
        }

        .nav-link {
            color: #343a40;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">과제3 : 쇼핑몰 과제</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse show" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/product/list.do">목록보기</a>
            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${empty userId}">
                        <a class="nav-link" href="/member/login.do">로그인</a>
                    </c:when>
                    <c:when test="${not empty userId}">
                        <a class="nav-link" href="/member/logout.do">로그아웃</a>
                    </c:when>
                </c:choose>
            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${empty userId}">
                        <a class="nav-link" href="/member/join.do">회원가입</a>
                    </c:when>
                    <c:when test="${not empty userId}">
                        <a class="nav-link" href="/member/info.do?user_id=${userId}">내 정보</a>
                    </c:when>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>

<!-- Add Bootstrap JS (Popper.js and jQuery are required for Bootstrap JS) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
