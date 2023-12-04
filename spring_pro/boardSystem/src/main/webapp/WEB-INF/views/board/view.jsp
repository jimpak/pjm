<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-3">
    <h2>게시물 상세페이지</h2>
    <div class="mb-3 mt-3">
        <label for="bno" class="form-label">Bno:</label>
        <input type="text" class="form-control" id="bno" name="bno" value="${boardDTO.bno}" readonly>
    </div>
    <div class="mb-3 mt-3">
        <label for="title" class="form-label">Title:</label>
        <input type="text" class="form-control" id="title" value="${boardDTO.title}" readonly>
    </div>
    <label for="content">Content:</label>
    <textarea class="form-control" rows="5" id="content" readonly>${boardDTO.content}</textarea>
    <div class="mb-3 mt-3">
        <label for="writer" class="form-label">Writer:</label>
        <input type="text" class="form-control" id="writer" value="${boardDTO.writer}" readonly>
    </div>
    <div class="mb-3 mt-3">
        <label for="visitcount" class="form-label">VisitCount:</label>
        <input type="text" class="form-control" id="visitcount" value="${boardDTO.visitcount}" readonly>
    </div>
    <div class="mb-3 mt-3">
        <label class="form-date-label">PostDate</label>
        <input class="form-date-input" type="date" id="postdate" value="${boardDTO.postdate}" readonly>
    </div>
    <button type="button" id="modify" class="btn btn-primary">modify</button>
    <button type="button" id="remove" class="btn btn-danger">remove</button>
    <button type="button" id="list" class="btn btn-info">list</button>
</div>
<script>
    $(function() {
        $("#modify").click(function() {
          location.href = "/board/modify?bno=" + `${boardDTO.bno}`
        });
        $(".btn-danger").click(function() {
            location.href = "/board/remove?bno=" + `${boardDTO.bno}`
        });
        $("#list").click(function (){
            location.href = "/board/list"
        });
    })
</script>

<%@include file="../includes/footer.jsp" %>