<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>useBean 액션태그</h2>

<h3>javaBean 생성하기</h3>
<jsp:useBean id="person" class="common.Person" scope="request"></jsp:useBean>

<h3>setProperty 액션 태그로 자바빈즈 속성 지정하기</h3>
<jsp:setProperty name="person" property="name" value="임꺽정"/>
<jsp:setProperty name="person" property="age" value="30"/>

<h3>getProperty 액션태그로 자바빈즈 속성 읽기</h3>
<li> 이름 : <jsp:getProperty name="person" property="name"/></li>
<li> 나이 : <jsp:getProperty name="person" property="age"/></li>

</body>
</html>
