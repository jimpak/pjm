<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp"%>

<div class="container mt-3">
    <h2>게시판 리스트</h2>
    <p>TotalCount : ${totalCount}</p>
    <table class="table table-striped">
        <thead>
        <tr align="center">
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${boardList}">
            <tr align="center">
                <td>${board.bno}</td>
                <td><a href="view?bno=${board.bno}">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.visitcount}</td>
                <td>${board.postdate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../includes/footer.jsp"%>