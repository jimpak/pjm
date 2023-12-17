<%@ page import="common.OracleJDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>오라클 DB 회원데이터 저장</h2>
<%
    OracleJDBConnect ojdbc = new OracleJDBConnect();
    String id = "test11";
    String pass = "test11";
    String name = "테스트1회원";

    String sql = "insert into member(id, pass, name) values(?,?,?)";
    PreparedStatement pstmt = ojdbc.conn.prepareStatement(sql);
    pstmt.setString(1, id);
    pstmt.setString(2, pass);
    pstmt.setString(3, name);

    int inResult = pstmt.executeUpdate();
    out.println(inResult + "행이 입력되었습니다.");

    ojdbc.close();
%>
</body>
</html>
