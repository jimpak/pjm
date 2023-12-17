<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>각 영역별 저장된 속성 읽기</h2>
<ul>
    <li>페이지 영역: ${pageScope.scopeValue}</li>
    <li>리퀘스트 영역: ${requestScope.scopeValue}</li>
    <li>세션 영역: ${sessionScope.scopeValue}</li>
    <li>애플리케이션 영역: ${applicationScope.scopeValue}</li>
</ul>
<ul>
    <%--변수의 이름이 같을 경우 가장 작은 영역의 값이 출력됨--%>
    <li>${scopeValue}</li> <%--페이지 영역 출력됨.--%>
</ul>
<%--링크로 넘어가면 세션값이 유지됨.--%>
<a href="elTest03.jsp">elTest03.jsp로 이동</a>
</body>
</html>
