<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
  long add_date = s.parse(request.getParameter("add_date")).getTime();
  int add_int = Integer.parseInt(request.getParameter("add_int"));
  String add_str = request.getParameter("add_str");

  // 응답헤더에 추가
  response.addDateHeader("myDate", add_date);
  response.addIntHeader("myInt", add_int);
  response.addHeader("myName", add_str);
  response.setHeader("myName", "홍길동");
  response.setHeader("myAge", "10살");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>응답헤더 출력</h2>
<%
  Collection<String> headerNames = response.getHeaderNames();
  for(String hName : headerNames) {
    String hValue = response.getHeader(hName);
    out.println(hName + " : " + hValue + "</br>");
  }
%>
</body>
</html>
