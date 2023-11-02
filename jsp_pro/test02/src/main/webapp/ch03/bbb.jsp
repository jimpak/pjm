<%@ page import="common.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    // 값이 존재하지 않기 때문에 500 에러 발생
    Object name = pageContext.getAttribute("name");
    Object score = pageContext.getAttribute("score");
    Object p1 = pageContext.getAttribute("person1");
//    Person p2 = (Person)request.getAttribute("person2");
    Object p2 = request.getAttribute("person2");
    Object p3 = session.getAttribute("person3");
%>

<ul>
    <li><%=(name == null) ? "이름 값 없음" : name%></li>
    <li><%=(score == null) ? "점수 값 없음" : score%></li>
    <li><%=(p1 == null) ? "값 없음" : ((Person)p1).getName()%></li>
    <li><%=(p1 == null) ? "값 없음" : ((Person)p1).getAge()%></li>
<%--    <li><%=p2.getName()%>, <%=p2.getAge()%></li>--%>
    <li>request 객체 정보 : <%=(p2 == null) ? "값 없음" : ((Person)p2).getName()%></li>
    <li>request 객체 정보 : <%=(p2 == null) ? "값 없음" : ((Person)p2).getAge()%></li>
    <li>session 객체 정보 : <%=(p3 == null) ? "값 없음" : ((Person)p3).getName()%></li>
    <li>session 객체 정보 : <%=(p3 == null) ? "값 없음" : ((Person)p3).getAge()%></li>
</ul>

</body>
</html>

<%--
request와 session 객체만 값이 넘어옴.
해당 페이지 바로 실행 시 request 정보는 넘어오지 않음. 왜? 요청한적이 없으니까
session은 걍 넘어옴.
--%>