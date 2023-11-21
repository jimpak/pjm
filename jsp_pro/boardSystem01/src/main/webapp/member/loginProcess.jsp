<%@ page import="model1.member.MemberDTO" %>
<%@ page import="model1.member.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userId = request.getParameter("user_id");
    String userPw = request.getParameter("user_pw");

    // 회원 테이블 DAO를 통해 히원 정보 DTO 획득
    MemberDAO dao = new MemberDAO();
    MemberDTO memberDTO = dao.getMemberDTO(userId, userPw);
    dao.close();

    // 로그인 성공 여부에 따른 처리
    if(memberDTO.getId() != null) {
        // 로그인 성공
        session.setAttribute("userId", memberDTO.getId());
        session.setAttribute("userName", memberDTO.getName());
        response.sendRedirect("../board/list.do");
    } else {
        // 로그인 실패
        request.setAttribute("loginErrMsg", "로그인 오류입니다.");
        request.getRequestDispatcher("loginForm.jsp").forward(request, response);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
