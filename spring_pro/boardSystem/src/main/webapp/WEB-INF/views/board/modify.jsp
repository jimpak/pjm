<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-3">
<h2>게시물 등록 페이지</h2>
<p>${error}<br><p>
<form action="/board/modify" method="post">
    <input type="hidden" name="bno" value="${boardDTO.bno}">
    <div class="mb-3 mt-3">
        <label for="title" class="form-label">Title:</label>
        <input type="text" class="form-control" id="title" value="${boardDTO.title}" name="title">
    </div>
    <label for="content">Content:</label>
    <textarea class="form-control" rows="5" id="content" name="content">${boardDTO.content}</textarea>
    <div class="mb-3">
        <label for="writer" class="form-label">Writer:</label>
        <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" disabled>
    </div>
    <div class="mb-3">
        <label class="form-date-label">PostDate</label>
        <input class="form-date-input" type="date" name="postdate" disabled>
    </div>
    <button type="submit" class="btn btn-primary">Modify</button>
    <button type="button" class="btn btn-secondary">List</button>
</form>
</div>
<script>
    // $(function() {
    //     $(".btn-secondary").click(function () {
    //         location.href = "/board/list"
    //     });
    // })

    document.querySelector(".btn-secondary").addEventListener("click", function (e) {
        e.preventDefault();
        self.location=`/board/list?bno=${boardDTO.bno}&${pageRequestDTO.link}`
    })
</script>


<%@ include file="../includes/footer.jsp" %>