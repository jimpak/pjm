<%@ page import="utils.JSFunction" %>
<%@ page import="model1.product.ProductDAO" %>
<%@ page import="model1.product.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int pcode = Integer.parseInt(request.getParameter("pcode"));
    ProductDAO dao = new ProductDAO();
    ProductDTO dto = dao.selectView(pcode);
    String sessionId = session.getAttribute("userId").toString();
    if(!sessionId.equals(dto.getUser_id())) {
        JSFunction.alertBack("작성자만 수정할 수 있습니다.", out);
        return;
    }
    dao.close();
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function validateForm(form){
            if(form.pname.value == ""){
                alert("상품명을 입력하세요");
                form.pname.focus();
                return false;
            }
            if(form.description.value == ""){
                alert("상품에 대한 설명을 입력하세요");
                form.description.focus();
                return false;
            }
            if(form.price.value == ""){
                alert("가격을 입력하세요.");
                form.price.focus();
                return false;
            }
            if(form.amount.value == ""){
                alert("수량을 입력하세요.");
                form.amount.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<jsp:include page="../common/link.jsp"/>
<h2>게시글 수정 폼</h2>
<form name="editFrm" method="post" action="editProcess.jsp" onsubmit="return validateForm(this)">
    <input type="hidden" name="pcode" value="<%=pcode%>">
    <table>
        <tr><td>상품명 : </td><td><input type="text" name="pname" value="<%=dto.getPname()%>"></td></tr>
        <tr><td>상품내용 : </td><td><textarea name="description" style="height: 100px" value="<%=dto.getDescription()%>"></textarea></td></tr>
        <tr><td>가격 : </td><td><input type="text" name="price" value="<%=dto.getPrice()%>"></td></tr>
        <tr><td>수량 : </td><td><input type="text" name="amount" value="<%=dto.getAmount()%>"></td></tr>
        <tr>
            <td colspan="2">
                <button type="submit">게시글 수정</button>
                <button type="reset">새로고침</button>
                <button type="button" onclick="location.href='list.jsp'">목록보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
