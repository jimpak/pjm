<%@ page import="common.MySQLConnectPool" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원 목록 조회</h2>
<%
  MySQLConnectPool mscp = new MySQLConnectPool();
  String sql = "select * from member";
  Statement stml = mscp.conn.createStatement();
  ResultSet rs = stml.executeQuery(sql);

  while(rs.next()) {
    int mno = rs.getInt("mno");
    String id = rs.getString("id");
    String pw = rs.getString("pass");
    String name = rs.getString("name");
    Date regidate = rs.getDate("regidate");
    out.println(String.format("%s %s %s %s %s", mno, id, pw, name, regidate) + "<br>");
  }
  mscp.close();
%>
</body>
</html>
