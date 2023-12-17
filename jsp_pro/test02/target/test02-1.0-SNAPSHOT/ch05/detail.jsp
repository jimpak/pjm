<%@ page import="common.JDBConnect" %>
<%@ page import="common.MemberDTO" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원 상세정보 보기</h2>
<%
  int mno = Integer.parseInt(request.getParameter("mno"));
  JDBConnect jdbc = new JDBConnect();
  MemberDTO m = null;
  String sql = "select * from member where mno = ?";
  PreparedStatement pstmt = jdbc.conn.prepareStatement(sql);
  pstmt.setInt(1, mno);
  ResultSet rs = pstmt.executeQuery();

  if(rs.next()) {
    m = new MemberDTO();
    m.setMno(mno);
    m.setId(rs.getString("id"));
    m.setPass(rs.getString("pass"));
    m.setName(rs.getString("name"));
    m.setRegidate(rs.getDate("regidate"));
  }
%>
<form action="update.jsp" method="post">
  <table>
    <tr><td>회원번호</td><td><input type="text" name="mno" value="<%=m.getMno()%>" readonly></td></tr>
      <tr><td>회원아이디</td><td><input type="text" name="id" value="<%=m.getId()%>" readonly></td></tr>
      <tr><td>회원비밀번호</td><td><input type="text" name="pass" value="<%=m.getPass()%>"></td></tr>
      <tr><td>회원이름</td><td><input type="text" name="name" value="<%=m.getName()%>"></td></tr>
      <tr><td>회원등록일</td><td><%=m.getRegidate()%></td></tr>
      <tr><td colspan="2">
        <input type="button" value="목록보기" onclick="location.href='list.jsp'">
        <input type="submit" value="수정">
        <input type="button" value="삭제" onclick="location.href='delete.jsp?mno=<%=m.getMno()%>'">
      </td></tr>
  </table>
</form>
</body>
</html>
