<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
        function validateForm(form) {
            if (form.pname.value == "") {
                alert("상품명을 입력하세요");
                form.pname.focus();
                return false;
            }
            if (form.description.value == "") {
                alert("상품내용을 입력하세요");
                form.description.focus();
                return false;
            }
            if (form.price.value == "") {
                alert("가격을 입력하세요");
                form.price.focus();
                return false;
            }
            if (form.amount.value == "") {
                alert("수량을 입력하세요");
                form.amount.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">파일첨부형 상품 등록</h2>
    <form name="writeFrm" method="post" enctype="multipart/form-data"
          action="/product/write.do" onsubmit="return validateForm(this);">
        <div class="form-group row">
            <label name="user_id" class="col-sm-2 col-form-label">작성자</label>
            <div class="col-sm-10">
                <input type="text" name="user_id" value="${userId}" class="form-control" readonly>
            </div>
        </div>
        <div class="form-group row">
            <label name="pname" class="col-sm-2 col-form-label">상품명</label>
            <div class="col-sm-10">
                <input type="text" name="pname" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label name="description" class="col-sm-2 col-form-label">상품내용</label>
            <div class="col-sm-10">
                <textarea name="description" class="form-control" style="height: 100px;"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <label name="price" class="col-sm-2 col-form-label">가격</label>
            <div class="col-sm-10">
                <input type="text" name="price" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label name="amount" class="col-sm-2 col-form-label">수량</label>
            <div class="col-sm-10">
                <input type="text" name="amount" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label name="ofile" class="col-sm-2 col-form-label">첨부파일</label>
            <div class="col-sm-10">
                <input type="file" name="ofile" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10 offset-sm-2">
                <button type="submit" class="btn btn-primary">작성완료</button>
                <button type="reset" class="btn btn-secondary">RESET</button>
                <button type="button" class="btn btn-info" onclick="location.href='/product/list.do'">목록보기</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>