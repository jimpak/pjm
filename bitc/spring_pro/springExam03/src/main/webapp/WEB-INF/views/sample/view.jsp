<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>번호 : ${sample.idx}</div>
<div>이름 : ${sample.name}</div>
<div>나이 : ${sample.age}</div>
<div>연락처 : ${sample.phone}</div>
<div>등록일 : ${sample.postdate}</div>
<button onclick="location.href='/sample/update?idx=${sample.idx}'">수정하기</button>
<button onclick="location.href='/sample/delete?idx=${sample.idx}'">삭제하기</button>
<button onclick="location.href='/sample/list'">목록보기</button>
</body>
</html>
