<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-3">
    <h2>검색 영역</h2>
    <form class="form-inline" method="get">
        <div class="row">
            <div class="col-md-6 mb-2">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" name="types" value="t" ${pageRequestDTO.checkType('t')?'checked':''}>
                    <label class="form-check-label">Title</label>
                </div>
            </div>
            <div class="col-md-6 mb-2">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" name="types" value="c" ${pageRequestDTO.checkType('c')?'checked':''}>
                    <label class="form-check-label">Content</label>
                </div>
            </div>
        </div>
        <div class="input-group mb-3">
            <input type="text" name="keyword" class="form-control" placeholder="Search" value="${pageRequestDTO.keyword}">
        </div>
        <div class="input-group mb-3 dueDateDiv">
            <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
            <input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
        </div>
        <div class="input-group mb-3">
            <div class="float-end">
                <button class="btn btn-primary" type="submit">Search</button>
                <button class="btn btn-info" type="reset">Clear</button>
            </div>
        </div>
    </form>

    <h2>게시판 리스트</h2>
    <p>TotalCount : ${responseDTO.total}</p>
    <table class="table table-striped">
        <thead>
        <tr align="center">
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>댓글 수</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${responseDTO.dtoList}">
            <tr align="center">
                <td>${board.bno}</td>
                <td><a href="view?bno=${board.bno}&${pageRequestDTO.link}">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.visitcount}</td>
                <td>${board.replycount}</td>
                <td>${board.postdate}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5" align="center">
                <div style="display: flex; justify-content: center;">
                    <ul class="pagination">
                        <c:if test="${responseDTO.prev}">
                            <li class="page-item"><a class="page-link" data-num="${responseDTO.start-1}">Previous</a>
                            </li>
                        </c:if>
                        <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                            <li class="page-item ${num==responseDTO.page?'active':''}">
                                <a class="page-link" data-num="${num}">${num}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${responseDTO.next}">
                            <li class="page-item"><a class="page-link" data-num="${responseDTO.end+1}">Next</a></li>
                        </c:if>
                    </ul>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script>
    document.querySelector(".pagination").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        const target = e.target;
        if (target.tagName != 'A') {
            return;
        }
        const num = target.getAttribute("data-num");
        // 페이지 이동할때 검색정보 가지고 다니는 법
        const formObj = document.querySelector("form");
        formObj.innerHTML += `<input type="hidden" name="page" value="\${num}">`
        formObj.submit();

        // self.location = `/board/list?page=\${num}`
    }, false)
</script>

<%@include file="../includes/footer.jsp" %>