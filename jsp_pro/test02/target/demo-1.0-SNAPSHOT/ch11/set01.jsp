<%@ page import="java.util.ArrayList" %>
<%@ page import="common.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ArrayList<Person> pList = new ArrayList<Person>();
    pList.add(new Person("홍길동", 20));
    pList.add(new Person("성삼문", 30));
    pList.add(new Person("강감찬", 40));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="num1" value="10" />
<c:set var="num2">20</c:set>
<c:remove var="num1"/> <%--변수 삭제--%>
<c:set var="pList" value="<%=pList%>"/>

num1 : ${num1} <br>
num2 : ${num2} <br>
<ul>
    <li>${pList[0].name}, ${pList[0].age}</li>
    <li>${pList[1].name}, ${pList[1].age}</li>
    <li>${pList[2].name}, ${pList[2].age}</li>
</ul>
<ul>
    <c:forEach var="person" items="${pList}">
        <li>${person.name}, ${person.age}</li>
    </c:forEach>
</ul>

<c:set var="num1" value="10"/>
<c:if test="${num1 >= 10}">
    10보다 크다
</c:if><br>

<c:choose>
    <c:when test="${num1 >= 10}">
        10보다 크거나 같다
    </c:when>
    <c:when test="${num2 > 5}">
        5보다 크고 10보다 작거나 같다
    </c:when>
</c:choose>

</body>
</html>
