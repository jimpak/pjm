<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Hello~!~!~!~!~!~!!!!</h2>
<%!
    String s1 = "jsp";
    String s2 = "안녕하세요";
%>
<h1> 파일 <%=s1%></h1>
<%
out.println(s2 + "<br>");
%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

Enumeration headers = request.getHeaderNames();
while (headers.hasMoreElements()) {
    String headerName = (String)headers.nextElement();
    String headerValue = request.getHeader(headerName);
    out.println(headerName + ":" + headerValue + "<br>");
}
%>
<h1>아이디 : <%=id%></h1>
<h1>비밀번호 : <%=pw%></h1>
<%--
http://localhost:8082/hello.jsp
id : null
pw : null로 출력

http://localhost:8082/hello.jsp?id=qwer&pw=1234
id : qwer
pw : 1234로 출력
--%>
</body>
</html>
