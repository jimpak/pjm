<%@ page import="common.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원 리스트 조회</h2>
<%
  List<MemberDTO> memberList = new ArrayList<MemberDTO>();
  JDBConnect jdbc = new JDBConnect();
  String sql = "select * from member";
  Statement stmt = jdbc.conn.createStatement();
  ResultSet rs = stmt.executeQuery(sql);

  while(rs.next()) {
    int mno = rs.getInt("mno");
    String id = rs.getString("id");
    String pass = rs.getString("pass");
    String name = rs.getString("name");
    Date regidate = rs.getDate("regidate");
    // 리스트에 추가
    memberList.add(new MemberDTO(mno, id, pass, name, regidate));
  }
  jdbc.close();
%>
<table>
  <tr>
    <th>mno</th>
    <th>id</th>
    <th>pass</th>
    <th>name</th>
    <th>regidate</th>
  </tr>
  <%
    for(int i = 0; i < memberList.size(); i++) {
      MemberDTO m = memberList.get(i);
      %>
  <tr>
    <td><%=m.getMno()%></td>
    <td><a href="detail.jsp?id=<%=m.getId()%>"><%=m.getId()%></a></td>
    <td><%=m.getPass()%></td>
    <td><%=m.getName()%></td>
    <td><%=m.getRegidate()%></td>
  </tr>
<%
    }
%>
</table>
</body>
</html>
