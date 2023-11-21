<%@ page import="utils.JSFunction" %>
<%@ page import="model1.product.ProductDTO" %>
<%@ page import="model1.product.ProductDAO" %>
<%@ page import="model1.member.MemberDTO" %>
<%@ page import="model1.member.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pname = request.getParameter("pname");
    String description = request.getParameter("description");
    int price = Integer.parseInt(request.getParameter("price"));
    int amount = Integer.parseInt(request.getParameter("amount"));

    ProductDTO dto = new ProductDTO();
    dto.setUser_id(session.getAttribute("userId").toString());
    dto.setPname(pname);
    dto.setDescription(description);
    dto.setPrice(price);
    dto.setAmount(amount);

    ProductDAO dao = new ProductDAO();
    int iResult = dao.insertWrite(dto);
    dao.close();

    MemberDAO mdao = new MemberDAO();
    mdao.updateMilage(dto);
    mdao.close();

    if(iResult == 1) {
        response.sendRedirect("list.jsp");
    } else {
        JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
