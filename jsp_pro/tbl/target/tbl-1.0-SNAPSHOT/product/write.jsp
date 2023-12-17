<%@ page import="utils.JSFunction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if(session.getAttribute("userId") == null) {
      JSFunction.alertLocation("로그인 후 이용해 주세요", "../member/loginForm.jsp", out);
      return;
  }
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
<h2>상품등록 폼</h2>
<form name="wirteFrm" method="post" action="writeProcess.jsp" onsubmit="return validateForm(this)">
    <table>
        <tr><td>상품명 : </td><td><input type="text" name="pname" style="width: 80%"></td></tr>
        <tr><td>상품내용 : </td><td><textarea name="description" style="width: 80%; height: 100px"></textarea></td></tr>
        <tr><td>가격 : </td><td><input type="text" name="price" style="width: 80%"></td></tr>
        <tr><td>수량 : </td><td><input type="text" name="amount" style="width: 80%"></td></tr>
        <tr>
            <td colspan="2">
                <button type="submit">상품등록</button>
                <button type="reset">새로고침</button>
                <button type="button" onclick="location.href='list.jsp'">목록보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
