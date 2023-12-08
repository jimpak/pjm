<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<script>
    function validateForm(form) {
        if(form.username.value == "") {
            alert("작성자를 입력하세요");
            form.username.focus();
            return false;
        }
        if(form.password.value == "") {
            alert("제목을 입력하세요");
            form.password.focus();
            return false;
        }
        if(form.name.value == "") {
            alert("내용을 입력하세요");
            form.name.focus();
            return false;
        }
        if(form.nick.value == "") {
            alert("비밀번호를 입력하세요");
            form.nick.focus();
            return false;
        }
    }
</script>

<div class="container mt-3">
    <h2>회원가입 페이지</h2>
    <form action="/member/join" method="post">
        <div class="mb-3 mt-3">
            <label for="username" class="form-label">UserName:</label>
            <input type="text" class="form-control" id="username" placeholder="아이디를 입력하세요" name="username">
            <button type="button" id="idConformBtn" class="btn btn-info">중복확인</button>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" name="password">
        </div>
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="사용자명을 입력하세요" name="name">
        </div>
        <div class="mb-3 mt-3">
            <label for="nick" class="form-label">NickName:</label>
            <input type="text" class="form-control" id="nick" placeholder="닉네임을 입력하세요" name="nick">
            <button type="button" id="nickConformBtn" class="btn btn-info">중복확인</button>
        </div>
        <button type="submit" class="btn btn-primary">회원가입</button>
        <button type="reset" class="btn btn-primary">Reset</button>
    </form>
</div>

<script>
    $("#nickConformBtn").click(function () {
        var nickname = $("#nick").val();
        $.ajax({
            type: "get",
            url: "/member/conformedNickname/" + nickname
        }).done(function (resp) {
            console.log(resp);
            if(resp == 'success') {
                alert(nickname + "은 사용가능합니다.")
            } else {
                alert(nickname + "은 이미 존재합니다.")
            }
        })
    })
    $("#idConformBtn").click(function () {
        var username = $("#username").val();
        $.ajax({
            type: "get",
            url: "/member/conformedUsername/" + username
        }).done(function (resp) {
            console.log(resp);
            if(resp == 'success') {
                alert(username + "은 사용가능합니다.")
            } else {
                alert(username + "은 이미 존재합니다.")
            }
        })
    })
</script>

<%@ include file="../includes/footer.jsp" %>