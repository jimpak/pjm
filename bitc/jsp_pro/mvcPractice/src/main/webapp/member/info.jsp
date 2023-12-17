<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<html>
<head>
    <title>마이페이지</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<div class="container mt-5">
    <h2>마이페이지</h2>
    <form name="viewFrm">
        <input type="hidden" name="user_id" value="${userId}">
        <table class="table table-bordered">
            <tr>
                <td>아이디 :</td>
                <td>${userId}</td>
            </tr>
            <tr>
                <td>패스워드 :</td>
                <td>${dto.pass}</td>
            </tr>
            <tr>
                <td>이름 :</td>
                <td>${dto.user_name}</td>
            </tr>
            <tr>
                <td>가입날짜 :</td>
                <td>${dto.regidate}</td>
            </tr>
            <tr>
                <td>마일리지 :</td>
                <td>${dto.mileage}</td>
            </tr>

            <tr>
                <td colspan="2">
                    <button type="button" class="btn btn-info" onclick="location.href='/product/list.do'">목록보기</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
