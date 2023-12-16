<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script>
        function replyInsert() {
            var data1 = {
                "pcode": $("#pcode").val(),
                "user_id": $("#user_id").val(),
                "content": $("#content").val()
            }
            $.ajax({
                type: "POST",
                url: "/product/reply.do",
                data: data1,
                dataType: "text",
                success: function (result) {
                    if (result == 'success') {
                        alert("댓글 입력 성공")
                        location.href = "/product/view.do?pcode=" + $("#pcode").val()
                    } else {
                        alert("댓글 입력실패")
                    }
                }
            });
        }

        function reply_delete(rnum) {
            var data1 = {"mode": "reply_del", rnum: rnum}
            $.ajax({
                type: "POST",
                url: "/product/pass.do",
                data: data1,
                dataType: "text",
                success: function (result) {
                    if (result == "success") {
                        alert("삭제성공")
                        location.href = "/product/view.do?pcode=" + $("#pcode").val()
                    } else {
                        alert("삭제 실패")
                    }
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<div class="container mt-5">
    <h2>파일첨부형 상품 상세보기</h2>
    <table class="table">
        <tr>
            <td>번호</td>
            <td>${dto.pcode}</td>
        </tr>
        <tr>
            <td>상품명</td>
            <td>${dto.pname}</td>
        </tr>
        <tr>
            <td>상품내용</td>
            <td>
                ${dto.description}
                <c:if test="${not empty dto.ofile and isImg eq true}">
                    <br><img src="/uploads/${dto.sfile}" class="img-fluid" style="max-width: 80%">
                </c:if>
            </td>
        </tr>
        <tr>
            <td>가격</td>
            <td>${dto.price}</td>
        </tr>
        <tr>
            <td>수량</td>
            <td>${dto.amount}</td>
        </tr>
        <tr>
            <td>사용자ID</td>
            <td>${dto.user_id}</td>
        </tr>
        <tr>
            <td>등록일</td>
            <td>${dto.postdate}</td>
        </tr>
        <tr>
            <td>조회수</td>
            <td>${dto.visitcount}</td>
        </tr>
        <tr>
            <td>첨부파일</td>
            <td>
                <c:if test="${not empty dto.ofile}">
                    ${dto.ofile}
                    <a href="/product/download.do?ofile=${dto.ofile}&sfile=${dto.sfile}&pcode=${dto.pcode}">[다운로드]</a>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>다운로드 수</td>
            <td>${dto.downcount}</td>
        </tr>
        <tr>
            <td>댓글 수</td>
            <td>${dto.replycount}</td>
        </tr>
        <tr colspan="3" align="center">
            <c:if test="${not empty userId && userId == dto.user_id}">
                <button type="button" onclick="location.href='/product/update.do?pcode=${dto.pcode}'">수정</button>
                <button type="button" onclick="location.href='/product/delete.do?pcode=${dto.pcode}'">삭제</button>
            </c:if>
            <button type="button" onclick="location.href='/product/list.do'">목록보기</button>
        </tr>
    </table>

    <c:if test="${userId != null && !userId.isEmpty()}">
        <h3 class="mt-3">댓글 작성</h3>
        <form name="replyform">
            <input type="hidden" id="pcode" value="${dto.pcode}">
            <div class="form-group row">
                <label for="user_id" class="col-sm-2 col-form-label">작성자</label>
                <div class="col-sm-10">
                    <input type="text" id="user_id" name="user_id" value="${userId}" class="form-control" readonly>
                </div>
            </div>
            <div class="form-group row">
                <label for="content" class="col-sm-2 col-form-label">댓글내용</label>
                <div class="col-sm-10">
                    <textarea name="content" id="content" rows="3" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <input id="replyBtn" type="button" onclick="replyInsert()" value="댓글작성" class="btn btn-primary">
                </div>
            </div>
        </form>
    </c:if>
    <h3>댓글 리스트</h3>
    <table class="table">
        <thead>
        <tr>
            <th>번호</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reply" items="${replyList}">
            <tr>
                <td>${reply.rnum}</td>
                <td>${reply.content}</td>
                <td>${reply.user_id}</td>
                <td>${reply.postdate}</td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="reply_delete(${reply.rnum})">삭제</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
