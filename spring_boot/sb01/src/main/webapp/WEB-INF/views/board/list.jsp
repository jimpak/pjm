<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<table>
    <tr>
        <td>bno</td>
        <td>title</td>
        <td>writer</td>
        <td>visitcount</td>
        <td>postdate</td>
    </tr>
    <c:forEach var="board" items="${boardList}">
        <tr>
            <td>${board.bno}</td>
            <td>${board.title}</td>
            <td>${board.writer}</td>
            <td>${board.visitcount}</td>
            <td>${board.postdate}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="../includes/footer.jsp" %>