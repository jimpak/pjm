<%@ page import="common.JDBConnect" %>
<%@ page import="common.OracleJDBConnect" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-11-06
  Time: 오후 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>JDBC Test 1</h2>
<%
    JDBConnect jdbc1 = new JDBConnect();
    jdbc1.close();
%>

<h2>JDBC Test 2</h2>
<%
    String driver = application.getInitParameter("MySQLDriver");
    String url = application.getInitParameter("MySQLURL");
    String id = application.getInitParameter("MySQLId");
    String pwd = application.getInitParameter("MySQLPwd");

    JDBConnect jdbc2 = new JDBConnect(driver, url, id, pwd);
    jdbc2.close();
%>

<h3>JDBC Test 3</h3>
<%
    JDBConnect jdbc3 = new JDBConnect(application);
    jdbc3.close();
%>

<h4>Oracle JDBC Test 1</h4>
<%
    OracleJDBConnect oraJdbc1 = new OracleJDBConnect();
    oraJdbc1.close();
%>
</body>
</html>
