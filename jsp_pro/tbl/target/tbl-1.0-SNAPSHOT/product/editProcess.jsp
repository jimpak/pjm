<%@ page import="utils.JSFunction" %>
<%@ page import="model1.product.ProductDTO" %>
<%@ page import="model1.product.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int pcode = Integer.parseInt(request.getParameter("pcode"));
    String pname = request.getParameter("pname");
    String description = request.getParameter("description");
    int price = Integer.parseInt(request.getParameter("price"));
    int amount = Integer.parseInt(request.getParameter("amount"));

    ProductDTO dto = new ProductDTO();
    dto.setPcode(pcode);
    dto.setPname(pname);
    dto.setDescription(description);
    dto.setPrice(price);
    dto.setAmount(amount);

    ProductDAO dao = new ProductDAO();
    int iResult = dao.updateEdit(dto);
    dao.close();

    if(iResult == 1) {
        response.sendRedirect("view.jsp?pcode=" + pcode);
    } else {
        JSFunction.alertBack("수정하기 실패", out);
    }
%>
