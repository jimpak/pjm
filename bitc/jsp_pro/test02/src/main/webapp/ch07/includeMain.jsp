<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 포함할 파일의 경로
    String outerPath1 = "./inc/outerPage1.jsp";
    String outerPath2 = "./inc/outerPage2.jsp";

    pageContext.setAttribute("pAttr", "홍길동");
    request.setAttribute("rAttr", 20);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>지시어로 페이지 포함하기</h2>
<%--<%@include file="./inc/outerPage1.jsp"%>--%>
<%--지시어의 경우 표현식 사용불가--%>
<%--<%@include file="<%=outerPath1%>"%>--%>
<%--<%@include file="./inc/outerPage2.jsp"%>--%>

<%--<p>외부파일 1에 선언한 변수 : <%=newVar1%></p>--%>
<%--<p>외부파일 2에 선언한 변수 : <%=newVar2%></p>--%>

<h2>액션으로 페이지 포함하기</h2>
<jsp:include page="./inc/outerPage1.jsp"/>
<%--태그는 둘다 사용가능--%>
<%--<jsp:include page="./inc/outerPage2.jsp"/>--%>
<jsp:include page="<%=outerPath2%>"/>
<%--태그로 include하는 경우 생성한 변수는 사용 불가--%>
<%--<p>외부파일 1에 선언한 변수 : <%=newVar1%></p>--%>
<%--<p>외부파일 2에 선언한 변수 : <%=newVar2%></p>--%>
</body>
</html>
