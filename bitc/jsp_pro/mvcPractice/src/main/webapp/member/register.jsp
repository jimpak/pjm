<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<div class="container mt-5">
    <h2>회원가입 폼</h2>
    <form name="registerFrm" method="post" action="/member/join.do" onsubmit="return validateForm(this)">
        <div class="form-group row">
            <label name="user_id" class="col-sm-2 col-form-label">아이디 :</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="user_id" style="width: 80%">
            </div>
        </div>
        <div class="form-group row">
            <label name="user_pass" class="col-sm-2 col-form-label">비밀번호 :</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="user_pass" style="width: 80%">
            </div>
        </div>
        <div class="form-group row">
            <label name="user_name" class="col-sm-2 col-form-label">사용자명 :</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="user_name" style="width: 80%">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10 offset-sm-2">
                <button type="submit" class="btn btn-primary">회원가입</button>
                <button type="reset" class="btn btn-secondary">새로고침</button>
                <button type="button" class="btn btn-info" onclick="location.href='/product/list.do'">목록보기</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
