<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<script>
    function validateForm(form) {
        if(form.username.value == "") {
            alert("ID를 입력하세요");
            form.username.focus();
            return false;
        }
        if(form.password.value == "") {
            alert("패스워드를 입력하세요");
            form.password.focus();
            return false;
        }
    }
</script>

<div class="container mt-3">
    <h2>로그인 페이지</h2>
    <h3 style="color: red">${msg}</h3>
    <form action="/member/login" method="post">
        <div class="mb-3 mt-3">
            <label for="username" class="form-label">UserName:</label>
            <input type="text" class="form-control" id="username" placeholder="아이디를 입력하세요" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
        <button type="button" class="btn btn-info">Join</button>
    </form>
</div>

<script>
    document.querySelector(".btn-info").addEventListener("click", function (e) {
        e.preventDefault;
        self.location = "/member/join";
    })
</script>

<%@ include file="../includes/footer.jsp" %>