<%@ page import="common.JDBConnect" %>
<%@ page import="common.OracleJDBConnect" %>
<%@ page import="common.MySQLConnectPool" %>
<%@ page import="common.OracleConnectPool" %>
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

<h2>MySQL ConnectPool 테스트</h2>
<%
    MySQLConnectPool mPool = new MySQLConnectPool();
    mPool.close();
%>

<h2>Oracle ConnectPool 테스트</h2>
<%
    OracleConnectPool oPool = new OracleConnectPool();
    oPool.close();
%>
</body>
</html>
