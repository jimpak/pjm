<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    ${userId}
    <td align="center">
      <% if(session.getAttribute("userId") == null) { %>
      <a href="../member/loginForm.jsp">로그인</a>
      &nbsp;
      <a href="../member/register.jsp">회원가입</a>
      <% } else { %>
      <a href="../member/logout.jsp">로그아웃</a>
      &nbsp;
      <a href="../member/info.jsp?user_id=${userId}">내 정보</a>
      <% } %>
    </td>
  </tr>
</table>
</body>
</html>
