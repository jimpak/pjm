<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
<%
// request : 사용자의 요청 정보를 저장
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
out.println("id : " + id);
out.println("pw : " + pw);
// http://localhost:8081/test01/request_test.jsp?id=abcd&pw=1234
%>

</body>
</html>