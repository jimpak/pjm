<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function validateForm(form){
            if(form.user_id.value == ""){
                alert("아이디를 입력하세요");
                form.user_id.focus();
                return false;
            }
            if(form.user_pass.value == ""){
                alert("비밀번호를 입력하세요");
                form.user_pass.focus();
                return false;
            }
            if(form.user_name.value == ""){
                alert("사용자명을 입력하세요.");
                form.user_name.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<h2>회원가입 폼</h2>
<form name="registerFrm" method="post" action="../member/registerProcess.jsp" onsubmit="return validateForm(this)">
    <table>
        <tr><td>아이디 : </td><td><input type="text" name="user_id" style="width: 80%"></td></tr>
        <tr><td>비밀번호 : </td><td><input type="password" name="user_pass" style="width: 80%; height: 100px"></td></tr>
        <tr><td>사용자명 : </td><td><input type="text" name="user_name" style="width: 80%"></td></tr>
        <tr>
            <td colspan="2">
                <button type="submit">게시글 등록</button>
                <button type="reset">새로고침</button>
                <button type="button" onclick="location.href='list.jsp'">목록보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
