<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="member" class="membership.MemberDTO" scope="request"/>
<jsp:setProperty name="member" property="id" value="abcd"/>
<jsp:setProperty name="member" property="pass" value="1234"/>
<jsp:setProperty name="member" property="name" value="박정민"/>
<jsp:forward page="ch07/member/memberView.jsp">

</jsp:forward>
</body>
</html>
