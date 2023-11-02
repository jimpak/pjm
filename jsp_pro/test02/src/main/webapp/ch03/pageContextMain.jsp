<%@ page import="common.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("name", "홍길동");
    pageContext.setAttribute("score", 80);
    pageContext.setAttribute("person1", new Person("한석봉", 20));
    request.setAttribute("person2", new Person("이순신", 33));
    session.setAttribute("person3", new Person("박정민", 32));
    application.setAttribute("person4", new Person("정도전", 45));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    getAttribute는 return형이 Object이기 때문에 형변환을 해줘야함
    String name = pageContext.getAttribute("name").toString();
    int score = (Integer)pageContext.getAttribute("score");
    Person p1 = (Person)pageContext.getAttribute("person1");
    Person p21 = (Person)request.getAttribute("person2");
    Person p3 = (Person)session.getAttribute("person3");
%>
<ul>
    <li><%=name%></li>
    <li><%=score%></li>
    <li><%=p1.getName()%>, <%=p1.getAge()%></li>
    <li><%=p21.getName()%>, <%=p21.getAge()%></li>
    <li><%=p3.getName()%>, <%=p3.getAge()%></li>
</ul>
<h2>Include page</h2>
<%@include file="aaa.jsp"%>
<%--<a href="aaa.jsp">aaa.jsp로 이동</a>--%>

<a href="ccc.jsp">ccc.jsp로 이동</a>

<%
//    request.getRequestDispatcher("bbb.jsp").forward(request, response);
%>
</body>
</html>
