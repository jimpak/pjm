<%@ page import="common.OracleConnectPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>오라클 DB 회원데이터 저장</h2>
<%
    OracleConnectPool ocp = new OracleConnectPool();

    int mno = -1;
    String id = "ortest11";
    String pass = "ortest11";
    String name = "ortest11회원";

    // dual = 가상의 테이블
    String seq_sql = "select seq_mno.nextval from dual";
    Statement stmt = ocp.conn.createStatement();
    ResultSet rs = stmt.executeQuery(seq_sql);

    if(rs.next()) {
        mno = rs.getInt(1);
    }

    String sql = "insert into member(mno, id, pass, name) values(?,?,?,?)";
    PreparedStatement pstmt = ocp.conn.prepareStatement(sql);
    pstmt.setInt(1, mno);
    pstmt.setString(2, id);
    pstmt.setString(3, pass);
    pstmt.setString(4, name);

    int inResult = pstmt.executeUpdate();
    out.println(inResult + "행이 입력되었습니다.");

    ocp.close();
%>
</body>
</html>
