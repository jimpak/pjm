<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>한번의 매핑으로 여러가지 요청처리</h2>
${resultValue}<br>
<ol>
  <li>URI : ${uri}</li>
  <li>요청명 : ${commandStr}</li>
</ol>
<ol>
  <li><a href="/ch12/regist.one">회원가입</a></li>
  <li><a href="/ch12/login.one">로그인</a></li>
  <li><a href="/ch12/freeboard.one">자유게시판</a></li>
</ol>
<form action="/ch12/post1.one" method="post">
  <input type="submit" value="post전송">
</form>
</body>
</html>
