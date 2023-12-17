<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>변수 선언</h2>
<c:set var="num1" value="10"></c:set>
<c:set var="num2">20</c:set>
num1 : ${num1}<br>
num2 : ${num2}<br>

<c:remove var="num1"></c:remove>
num1 : ${num1}<br>
num2 : ${num2}<br>

<h2>IF문 사용</h2>
<c:if test="${num1 > num2}" var="result">
    ${num1}이 {num2}보다 크다
</c:if>
result : ${result}

<h2>Choose문 1</h2>
<c:choose>
    <c:when test="${num1 > num2}">
        ${num1}이 ${num2}보다 크다
    </c:when>
    <c:when test="${num1 < num2}">
        ${num1}이 ${num2}보다 작다
    </c:when>
    <c:otherwise>
        ${num1}과 ${num2}이 같다
    </c:otherwise>
</c:choose>

<h2>Choose문 2</h2>
<c:set var="score" value="85" />
<c:choose>
    <c:when test="${score>=90}">A학점</c:when>
    <c:when test="${score>=80}">B학점</c:when>
    <c:when test="${score>=70}">C학점</c:when>
    <c:when test="${score>=60}">D학점</c:when>
    <c:otherwise>F학점</c:otherwise>
</c:choose>

<h2>forEach 구문 1</h2>
<c:set var="sum">0</c:set>
<c:forEach begin="1" end="10" step="1" var="i">
    <p>${sum = sum + i}</p>
</c:forEach>

<h2>forEach 구문 2 - 향상된 for문</h2>
<%
    String[] names = {"홍길동", "정은주", "김다연", "이민영", "이진솔"};
%>
<c:forEach items="<%=names%>" var="name">
    ${name}<br>
</c:forEach>

<table>
    <h2>forEach varStatus</h2>
    <c:forEach begin="6" end="10" step="1" var="i" varStatus="loop">
        <tr>
            <td>index:${loop.index}</td>
            <td>count:${loop.count}</td>
            <td>i:${i}</td>
            <td>current:${loop.current}</td>
            <td>first:${loop.first}</td>
            <td>last:${loop.last}</td>
        </tr>
    </c:forEach>

    <h2>향상된 forEach varStatus</h2>
    <c:forEach var="name" items="<%=names%>" varStatus="loop">
        <tr>
            <td>index:${loop.index}</td>
            <td>count:${loop.count}</td>
            <td>name:${name}</td>
            <td>current:${loop.current}</td>
            <td>first:${loop.first}</td>
            <td>last:${loop.last}</td>
        </tr>
    </c:forEach>
</table>

<%
    String nameStr = "홍길동, 정은주, 김다연, 이민영, 이진솔";
%>
<h2>forTokens 구문</h2>
<c:forTokens items="<%=nameStr%>" var="name" delims=",">
    name:${name}
</c:forTokens>

</body>
</html>
