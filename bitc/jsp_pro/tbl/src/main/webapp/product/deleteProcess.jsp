<%@ page import="utils.JSFunction" %>
<%@ page import="model1.product.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int pcode = Integer.parseInt(request.getParameter("pcode"));
    ProductDAO dao = new ProductDAO();
    int iResult = dao.deletePost(pcode);
    if(iResult == 1) {
        JSFunction.alertLocation("해당 게시물이 정상적으로 삭제되었습니다", "list.jsp", out);
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
