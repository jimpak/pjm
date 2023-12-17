<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
    <div class="container-fluid">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/board/list">게시물 리스트</a>
            </li>
            <c:if test="${not empty member}">
                <li class="nav-item">
                    <a class="nav-link" href="/board/register">게시물 등록</a>
                </li>
            </c:if>
            <c:choose>
                <c:when test="${empty member}">
                    <li class="nav-item">
                        <a class="nav-link" href="/member/login">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/join">회원가입</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/logout">로그아웃</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/info?username=${member.username}">내 정보</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
