<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("user_id");
    String pw = request.getParameter("user_pw");
    if(id.equalsIgnoreCase("abcd") && pw.equalsIgnoreCase("1234")) {
        response.sendRedirect("responseWelcome.jsp?id=" + id);
    } else {
        request.getRequestDispatcher("responseMain.jsp?loginErr=1").forward(request, response);
    }
%>
</body>
</html>
