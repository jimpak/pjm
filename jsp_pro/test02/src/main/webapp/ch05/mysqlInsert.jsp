<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-07
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>회원데이터 저장</h2>
<%
    JDBConnect mjdbc = new JDBConnect();
    String id = "test11";
    String pass = "test11";
    String name = "테스트1회원";

    String sql = "insert into member(id, pass, name) values(?,?,?)";
    PreparedStatement pstmt = mjdbc.conn.prepareStatement(sql);
    pstmt.setString(1, id);
    pstmt.setString(2, pass);
    pstmt.setString(3, name);

    int inResult = pstmt.executeUpdate();
    out.println(inResult + "행이 입력되었습니다.");

    mjdbc.close();
%>
</body>
</html>