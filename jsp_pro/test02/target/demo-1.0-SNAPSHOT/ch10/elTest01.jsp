<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("scopeValue", "페이지 영역");
    request.setAttribute("scopeValue", "리퀘스트 영역");
    session.setAttribute("scopeValue", "세션 영역");
    application.setAttribute("scopeValue", "애플리케이션 영역");
%>
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
<%--포워드는 리퀘스트 정보를 가지고 넘어감.--%>
<%--주소값은 01그대로 가지고 있지만 포워드로 인해 실제로 보이는 페이지는 02. 페이지 정보가 없음--%>
<jsp:forward page="elTest02.jsp"/>
</body>
</html>
