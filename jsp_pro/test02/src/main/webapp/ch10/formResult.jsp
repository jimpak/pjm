<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>이름 : ${param.name}</li>
    <li>성별 : ${param['gender']}</li>
    <li>학력 : ${param.grade}</li>
    <li>관심사 : ${paramValues.inter[0]}
        ${paramValues.inter[1]}
        ${paramValues.inter[2]}
        ${paramValues.inter[3]}</li>
</ul>
</body>
</html>
