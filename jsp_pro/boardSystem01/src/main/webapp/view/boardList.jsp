<%@ page import="common.BoardDTO" %>
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
<h2>게시판 리스트</h2>
<%
  List<BoardDTO> boardList = new ArrayList<BoardDTO>();
  JDBConnect jdbc = new JDBConnect();
  String sql = "select * from board";
  Statement stmt = jdbc.conn.createStatement();
  ResultSet rs = stmt.executeQuery(sql);

  while(rs.next()) {
    int num = rs.getInt("num");
    String title = rs.getString("title");
    String content = rs.getString("content");
    String id = rs.getString("id");
    Date postdate = rs.getDate("postdate");
    int visitcount = rs.getInt("visitcount");

    // 리스트에 추가
    boardList.add(new BoardDTO(num, title, content, id, postdate, visitcount));
  }
  jdbc.close();
%>
<table>
  <tr>
    <th>num</th>
    <th>title</th>
    <th>content</th>
    <th>id</th>
    <th>postdate</th>
    <th>visitcount</th>
  </tr>
  <%
    for(int i = 0; i < boardList.size(); i++) {
      BoardDTO b = boardList.get(i);
  %>
  <tr>
    <td><%=b.getNum()%></td>
    <td><%=b.getTitle()%></td>
    <td><%=b.getContent()%></td>
    <td><%=b.getId()%></td>
    <td><%=b.getPostdate()%></td>
    <td><%=b.getVisitcount()%></td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
