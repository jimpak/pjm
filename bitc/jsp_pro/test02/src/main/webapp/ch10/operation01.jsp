<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num1 = 10;
    pageContext.setAttribute("num2", 20);
    pageContext.setAttribute("num3", 30);
    pageContext.setAttribute("num4", 40);
    pageContext.setAttribute("str1", "");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>스크립틀릿에서 선언한 변수 : ${num1}</li>
    <li>page 영역에 선언한 변수 : ${num2}</li>
    <li>변수에 값 할당 즉시 출력: ${num1 = 7}</li>
    <li>변수에 값 할당 후 출력 : ${num1 = 8;''} => ${num1}</li>
    <li>num1 + num2 : ${num1 + num2}</li>
    <li>num1 - num2 : ${num1 - num2}</li>
    <li>num1 * num2 : ${num1 * num2}</li>
    <li>num1 / num2 : ${num1 / num2}</li>
    <li>num1 % num2 : ${num1 % num2}</li>
    <li>num1 div num2 : ${num1 div num2}</li> <%-- / --%>
    <li>num1 mod num2 : ${num1 mod num2}</li> <%-- % --%>
    <li>num1 > num2 : ${num1 > num2}</li>
    <li>num1 < num2 : ${num1 < num2}</li>
    <li>num1 == num2 : ${num1 == num2}</li>
    <li>num1 gt num2 : ${num1 gt num2}</li> <%-- == --%>

    <li>num1 < num2 && num3 < num4 : ${num1 < num2 && num3 < num4}</li>
    <li>num1 < num2 || num3 < num4 : ${num1 < num2 || num3 < num4}</li>
    <li>${empty num10}</li> <%--null값 확인--%>
    <li>${not empty num10}</li> <%--not null값 확인--%>
    <li>${not empty num1}</li> <%--not null값 확인--%>
    <li>${empty str1}</li> <%--""로 받아와도 null값 ture로 출력됨.--%>
</ul>
</body>
</html>
