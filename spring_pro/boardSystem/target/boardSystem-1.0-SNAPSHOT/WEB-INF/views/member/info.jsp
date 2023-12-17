<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-3">
    <h2>마이페이지</h2>
    <table class="table table-hover">
        <tbody>
        <tr>
            <td>UserName</td>
            <td>${member.username}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${member.name}</td>
        </tr>
        <tr>
            <td>NickName</td>
            <td>${member.nick}</td>
        </tr>
        <tr>
            <td>Regidate</td>
            <td>${member.regidate}</td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="button" class="btn btn-primary">비밀번호 변경</button>
                <button type="button" class="btn btn-dark" id="deleteBtn">회원 탈퇴</button>${msg}
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script>
    document.querySelector("#deleteBtn").addEventListener("click", function (e) {
        e.preventDefault();
        alert("정말 탈퇴하시겠습니까?");
        self.location = "/member/remove"
    })
</script>

<%@ include file="../includes/footer.jsp" %>