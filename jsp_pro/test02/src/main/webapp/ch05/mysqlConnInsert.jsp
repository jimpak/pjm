<%@ page import="common.MySQLConnectPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>회원데이터 저장</h2>
<%
    MySQLConnectPool mscp = new MySQLConnectPool();
    String id = "conte11";
    String pass = "conte11";
    String name = "conte11회원";

    String sql = "insert into member(id, pass, name) values(?,?,?)";
    PreparedStatement pstmt = mscp.conn.prepareStatement(sql);
    pstmt.setString(1, id);
    pstmt.setString(2, pass);
    pstmt.setString(3, name);

    int inResult = pstmt.executeUpdate();
    out.println(inResult + "행이 입력되었습니다.");

    mscp.close();
%>
</body>
</html>
