<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <td align="center">
      <c:choose>
        <c:when test="${empty userId}">
          <a href="/member/login.do">로그인</a>
          &nbsp;
          <a href="/member/register.do">회원가입</a>
        </c:when>

        <c:when test="${not empty userId}">
          <a href="/member/logout.do">로그아웃</a>
          &nbsp;
          <a href="/member/info.do?user_id=${userId}">내 정보</a>
        </c:when>
      </c:choose>
    </td>
  </tr>
</table>
</body>
</html>
