<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sample List</h2>
<table>
    <tr>
        <th>idx</th>
        <th>name</th>
        <th>age</th>
        <th>phone</th>
        <th>postdate</th>
    </tr>
    <c:forEach var="sample" items="${sampleList}">
        <tr>
            <td><a href="/sample/view?idx=${sample.idx}">${sample.idx}</a></td>
            <td>${sample.name}</td>
            <td>${sample.age}</td>
            <td>${sample.phone}</td>
            <td>${sample.postdate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
