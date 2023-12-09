<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<div class="container mt-5">
    <h2 class="mb-4">파일 첨부형 상품 목록보기</h2>
    <h3>검색 레코드 수 : ${totalCount}</h3>
    <form method="get">
        <div class="form-row align-items-center">
            <div class="col-auto">
                <select class="form-control" name="searchField">
                    <c:choose>
                        <c:when test="${map.searchField == 'pname'}">
                            <option value="">선택</option>
                            <option value="pname" selected>상품명</option>
                            <option value="description">상품내용</option>
                        </c:when>
                        <c:when test="${map.searchField == 'description'}">
                            <option value="">선택</option>
                            <option value="pname">상품명</option>
                            <option value="description" selected>상품내용</option>
                        </c:when>
                        <c:otherwise>
                            <option value="" selected>선택</option>
                            <option value="pname">상품명</option>
                            <option value="description">상품내용</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div class="col-auto">
                <input type="text" class="form-control" name="searchWord" value="${map.searchWord}">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary">검색하기</button>
            </div>
        </div>
    </form>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>번호</th>
            <th>상품명</th>
            <th>상품내용</th>
            <th>가격</th>
            <th>수량</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
            <th>다운로드수</th>
            <th>댓글수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr align="center">
                <td>${product.pcode}</td>
                <td><a href="/product/view.do?pcode=${product.pcode}">${product.pname}</a></td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td>${product.user_id}</td>
                <td>${product.postdate}</td>
                <td>${product.visitcount}</td>
                <td>${product.downcount}</td>
                <td>${product.replycount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row align-items-center">
        <div class="col">
            ${map.pageImg}
        </div>
        <div class="col">
            <button type="button" class="btn btn-success" onclick="location.href='/product/write.do'">글쓰기</button>
        </div>
    </div>
</div>
</body>
</html>