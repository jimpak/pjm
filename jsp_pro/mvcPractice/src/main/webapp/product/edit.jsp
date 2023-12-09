<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script>
        function validateForm(form) {
            if(form.pname.value == ""){
                alert("상품명을 입력하세요");
                form.pname.focus();
                return false;
            }
            if(form.description.value == ""){
                alert("상품내용을 입력하세요");
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
<div class="container mt-5">
    <h2>파일첨부형 상품 수정</h2>
    <form name="editFrm" method="post" enctype="multipart/form-data"
          action="/product/update.do" onsubmit="return validateForm(this);">
        <input type="hidden" name="pcode" value="${dto.pcode}">
        <input type="hidden" name="prevOfile" value="${dto.ofile}">
        <input type="hidden" name="prevSfile" value="${dto.sfile}">

        <div class="form-group row">
            <label name="user_id" class="col-sm-2 col-form-label">작성자</label>
            <div class="col-sm-10">
                <input type="text" name="user_id" value="${userId}" class="form-control" style="width: 150px;" readonly>
            </div>
        </div>
        <div class="form-group row">
            <label name="pname" class="col-sm-2 col-form-label">상품명</label>
            <div class="col-sm-10">
                <input type="text" name="pname" value="${dto.pname}" class="form-control" style="width: 150px;">
            </div>
        </div>
        <div class="form-group row">
            <label name="description" class="col-sm-2 col-form-label">상품내용</label>
            <div class="col-sm-10">
                <textarea name="description" class="form-control" style="width: 300px; height: 100px;">${dto.description}</textarea>
            </div>
        </div>
        <div class="form-group row">
            <label name="price" class="col-sm-2 col-form-label">가격</label>
            <div class="col-sm-10">
                <input type="text" name="price" value="${dto.price}" class="form-control" style="width: 150px;">
            </div>
        </div>
        <div class="form-group row">
            <label name="amount" class="col-sm-2 col-form-label">수량</label>
            <div class="col-sm-10">
                <input type="text" name="amount" value="${dto.amount}" class="form-control" style="width: 150px;">
            </div>
        </div>
        <div class="form-group row">
            <label name="ofile" class="col-sm-2 col-form-label">첨부파일</label>
            <div class="col-sm-10">
                <input type="file" name="ofile" class="form-control" style="width: 150px;">${dto.sfile}
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
