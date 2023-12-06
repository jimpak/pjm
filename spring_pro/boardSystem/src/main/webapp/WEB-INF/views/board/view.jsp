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

<div style="margin: 100px"></div>

<div class="container mt-3">
    <h2>댓글 리스트</h2>
    <div class="mb-3 mt-3">
        <label for="reply" class="form-label">Reply:</label>
        <textarea class="form-control" rows="3" id="reply" name="reply" placeholder="댓글을 입력하세요"></textarea>
    </div>
    <div class="mb-3 mt-3">
        <label for="replyer" class="form-label">Replyer:</label>
        <input type="text" class="form-control" id="replyer" name="replyer">
    </div>
    <button type="button" id="replyBtn" class="btn btn-primary">댓글 추가</button>
</div>
<div id="replyResult"></div>

<script>
    var init = function() {
        var bno = $("#bno").val();
        $.ajax({
            type:"get",
            url:"/replies/list/" + bno
        }).done(function(resp) {
            var str = "<table class='table table-bover mt-3'>";
            $.each(resp, function(key, val) {
                str += "<tr>"
                str += "<td>" + val.rno + "</td>"
                str += "<td>" + val.replyer + "</td>"
                str += "<td>" + val.reply + "</td>"
                str += "<td>" + val.replydate + "</td>"
                str += "<td><a href='javascript:rdel(" + val.rno + ")'>삭제</a></td>"
                str += "</tr>"
            })
            str += "</table>"
            $("#replyResult").html(str)
        })
    }

    $("replyBtn").click(function () {
        var data = {"bno":$("#bno").val(),
            "reply":$("#reply").val(),
            "replyer":$("#replyer").val()
        }
        $.ajax({
            type: "post",
            url: "replies/new",
            data: data
        }).done(function (resp) {
            console.log(resp)
            init()
        }).fail(function () {
            console.log("댓글 추가 실패")
        })
    })
</script>

<script>
    document.querySelector("#modify").addEventListener("click", function (e) {
        self.location = `/board/modify?bno=${boardDTO.bno}&${pageRequestDTO.link}`
    })
    document.querySelector("#remove").addEventListener("click", function (e) {
        self.location = `/board/remove?bno=${boardDTO.bno}`
    })
    document.querySelector("#list").addEventListener("click", function (e) {
        self.location = `/board/list?bno=${boardDTO.bno}&${pageRequestDTO.link}`
    })
    <%--$(function() {--%>
    <%--    $("#modify").click(function() {--%>
    <%--      location.href = "/board/modify?bno=" + `${boardDTO.bno}`--%>
    <%--    });--%>
    <%--    $(".btn-danger").click(function() {--%>
    <%--        location.href = "/board/remove?bno=" + `${boardDTO.bno}`--%>
    <%--    });--%>
    <%--    $("#list").click(function (){--%>
    <%--        location.href = "/board/list"--%>
    <%--    });--%>
    <%--})--%>
</script>

<%@include file="../includes/footer.jsp" %>