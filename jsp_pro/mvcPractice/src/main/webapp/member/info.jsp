<%@ page import="model1.member.MemberDAO" %>
<%@ page import="model1.member.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String userId = request.getParameter("user_id");
    MemberDAO dao = new MemberDAO();
    MemberDTO dto = dao.selectInfo(userId);
    dao.close();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<h2>마이페이지</h2>
<form name="viewFrm">
    <input type="hidden" name="user_id" value="<%=userId%>">
    <table>
        <tr>
            <td>아이디 : </td>
            <td>${userId}</td>
        </tr>
        <tr>
            <td>패스워드 : </td>
            <td><%=dto.getUser_pass()%></td>
        </tr>
        <tr>
            <td>이름 : </td>
            <td><%=dto.getUser_name()%></td>
        </tr>
        <tr>
            <td>가입날짜 : </td>
            <td><%=dto.getRegidate()%></td>
        </tr>
        <tr>
            <td>상품등록 수</td>
            <td><%=dto.getMilage()%></td>
        </tr>

        <tr>
            <td>
                <button type="button" onclick="location.href='../product/list.jsp'">목록보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
