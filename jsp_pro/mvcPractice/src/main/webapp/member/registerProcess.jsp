<%@ page import="utils.JSFunction" %>
<%@ page import="model1.member.MemberDTO" %>
<%@ page import="model1.member.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user_id = request.getParameter("user_id");
    String user_pass = request.getParameter("user_pass");
    String user_name = request.getParameter("user_name");

    MemberDTO dto = new MemberDTO();
    dto.setUser_id(user_id);
    dto.setUser_pass(user_pass);
    dto.setUser_name(user_name);

    MemberDAO dao = new MemberDAO();
    int iResult = dao.insertRegister(dto);
    dao.close();

    if(iResult == 1) {
        response.sendRedirect("../product/list.jsp");
    } else {
        JSFunction.alertBack("회원가입에 실패하였습니다.", out);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
