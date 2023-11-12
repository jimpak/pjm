<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberPro</title>
</head>
<body>
<jsp:useBean id="member" class="membership.MemberDTO" scope="request"></jsp:useBean>
<jsp:setProperty name="member" property="*"></jsp:setProperty>

<jsp:forward page="memberView.jsp"></jsp:forward>

<%--<jsp:forward page="memberView.jsp">--%>
<%--&lt;%&ndash;    아이디 : <jsp:getProperty name="member" property="id"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    비밀번호 : <jsp:getProperty name="member" property="pass"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    이름 : <jsp:getProperty name="member" property="name"/>&ndash;%&gt;--%>
<%--    <jsp:param name="id" value="abcd"/>--%>
<%--    <jsp:param name="pass" value="1234"/>--%>
<%--    <jsp:param name="name" value="박정민"/>--%>
<%--</jsp:forward>--%>
</body>
</html>
