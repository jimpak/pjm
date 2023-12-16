<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="formResult.jsp" method="post">
    이름 : <input type="text" name="name"><br>
    성별 :
    <input type="radio" name="gender" value="man">남자
    <input type="radio" name="gender" value="woman">여자<br>
    학력 :
    <select name="grade">
        <option value="ele">초딩</option>
        <option value="mid">중딩</option>
        <option value="high">고딩</option>
        <option value="uni">대딩</option>
    </select><br>
    관심사 :
    <input type="checkbox" name="inter" value="pol">정치
    <input type="checkbox" name="inter" value="eco">경제
    <input type="checkbox" name="inter" value="ent">연예
    <input type="checkbox" name="inter" value="spo">스포츠<br>

    <input type="submit" value="전송">
</form>
</body>
</html>
