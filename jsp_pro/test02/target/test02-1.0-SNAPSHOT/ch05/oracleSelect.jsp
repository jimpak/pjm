<%@ page import="common.OracleJDBConnect" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>오라클 DB활용 회원 목록 조회</h2>
<%
  OracleJDBConnect ojdbc = new OracleJDBConnect();
  String sql = "select * from member";
  Statement stml = ojdbc.conn.createStatement();
  ResultSet rs = stml.executeQuery(sql);

  while(rs.next()) {
    String id = rs.getString("id");
    String pw = rs.getString("pass");
    String name = rs.getString("name");
    Date regidate = rs.getDate("regidate");
    out.println(String.format("%s %s %s %s", id, pw, name, regidate) + "<br>");
  }
  ojdbc.close();
%>
</body>
</html>
