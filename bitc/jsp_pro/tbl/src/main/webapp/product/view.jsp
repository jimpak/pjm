<%@ page import="model1.product.ProductDAO" %>
<%@ page import="model1.product.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    int pcode = Integer.parseInt(request.getParameter("pcode"));
    ProductDAO dao = new ProductDAO();
    dao.updateVisitCount(pcode);
    ProductDTO dto = dao.selectView(pcode);
    dao.close();
%>
<html>
<head>
    <title>Title</title>
    <script>
        function deletePost() {
            var confirmed = confirm("정말 삭제하시겠습니까?");
            if(confirmed) {
                var form = document.viewFrm;
                form.method = "post";
                form.action = "deleteProcess.jsp";
                form.submit();
            }
        }
    </script>
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<h2>상품리스트</h2>
<c:set var="dto" value="<%=dto%>"/>
<form name="viewFrm">
    <input type="hidden" name="pcode" value="<%=pcode%>">
    <table>
        <tr>
            <td>번호</td>
            <td><%=pcode%></td>
        </tr>
        <tr>
            <td>상품명</td>
            <td><%=dto.getPname()%></td>
        </tr>
        <tr>
            <td>상품설명</td>
            <td><%=dto.getDescription()%></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><%=dto.getPrice()%></td>
        </tr>
        <tr>
            <td>수량</td>
            <td><%=dto.getAmount()%></td>
        </tr>
        <tr>
            <td>사용자ID</td>
            <td><%=dto.getUser_id()%></td>
        </tr>
        <tr>
            <td>방문자수</td>
            <td><%=dto.getVisitcount()%></td>
        </tr>
        <tr>
            <td colspan="2">
                <%--<% if(session.getAttribute("userId") != null && session.getAttribute("userId").toString().equals(dto.getId())) { %>--%>
                <c:if test="${not empty userId && userId == dto.user_id}">
                <button type="button" onclick="location.href='edit.jsp?pcode=<%=pcode%>'">수정하기</button>
                <button type="button" onclick="deletePost();">삭제하기</button>
                </c:if>
                <button type="button" onclick="location.href='list.jsp'">목록보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
