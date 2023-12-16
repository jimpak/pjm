<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JDBConnect jdbc = new JDBConnect();
    int mno = Integer.parseInt(request.getParameter("mno"));
//    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    String name = request.getParameter("name");

    String sql = "update member set pass=?, name=? where mno=?";
    PreparedStatement pstmt = jdbc.conn.prepareStatement(sql);
    pstmt.setString(1, pass);
    pstmt.setString(2, name);
    pstmt.setInt(3, mno);
    int intResult = pstmt.executeUpdate();
    jdbc.close();
    if(intResult == 1) {
        response.sendRedirect("list.jsp");
    } else {
        response.sendRedirect("detail.jsp?mno=" + mno);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
