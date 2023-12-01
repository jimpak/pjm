<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Board List</title>
</head>
<body>
<h2>Board List</h2>
<table>
    <tr align="center">
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>등록일</th>
    </tr>
    <c:forEach var="board" items="${boardList}">
        <tr align="center">
            <td>${board.bno}</td>
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>${board.writer}</td>
            <td>${board.visitcount}</td>
            <td>${board.postdate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
