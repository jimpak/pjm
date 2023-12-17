<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberView</title>
</head>
<body>
<%--아이디 : <%=request.getAttribute("param1")%>--%>
<%--비밀번호 : <%=request.getAttribute("param2")%>--%>
<%--이름 : <%=request.getAttribute("param3")%>--%>

<jsp:useBean id="member" class="membership.MemberDTO" scope="request" />
<ul>
    <li> 아이디 : <jsp:getProperty name="member" property="id"/></li>
    <li> 비밀번호 : <jsp:getProperty name="member" property="pass"/></li>
    <li> 이름 : <jsp:getProperty name="member" property="name"/></li>
</ul>

아이디 : <%=member.getId()%><br>
비밀번호 : <%=member.getPass()%><br>
이름 : <%=member.getName()%>

</body>
</html>
