<%@ page import="model1.board.BoardDAO" %>
<%@ page import="utils.JSFunction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    BoardDAO dao = new BoardDAO();
    int iResult = dao.deletePost(num);
    if(iResult == 1) {
        JSFunction.alertLocation("해당 게시물이 정상적으로 삭제되었습니다", "pagingList.jsp", out);
    } else {
        JSFunction.alertBack("삭제 실패", out);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>