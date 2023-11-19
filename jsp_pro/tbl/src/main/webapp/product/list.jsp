<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.ProductPage" %>
<%@ page import="model1.product.ProductDAO" %>
<%@ page import="model1.product.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  ProductDAO dao = new ProductDAO();
  Map<String, Object> param = new HashMap<>();
  String searchField = request.getParameter("searchField");
  String searchWord = request.getParameter("searchWord");
  if(searchWord != null) {
    param.put("searchField", searchField);
    param.put("searchWord", searchWord);
  }

  // 전체 게시물
  int totalCount = dao.selectCount(param);

  // 페이징 처리
  int pageSize = 10; // 한개의 페이지에 표시할 게시물 수
  int blockSize = 5; // 블록당 페이지 수
  int totalPage = (int)Math.ceil((double)totalCount/pageSize); // 전체페이지 수
  // 현재 페이지
  int pageNum = 1;
  String pageTemp = request.getParameter("pageNum");
  if(pageTemp != null && !pageTemp.equals("")) {
    pageNum = Integer.parseInt(pageTemp);
  }

  // 목록에 출력할 게시물 범위 계산
  int start = (pageNum - 1) * pageSize;
//  int start = (pageNum - 1) * pageSize + 1;
  int end = pageNum * pageSize; // mysql에서는 필요없지만 오라클에서는 end값 필요
  param.put("start", start);
  param.put("pageSize", pageSize);

  List<ProductDTO> productDTOList = dao.selectPagingList(param);
  dao.close();
%>

<html>
<head>
  <title>$Title$</title>
</head>
<body>
<jsp:include page="../common/link.jsp"></jsp:include>
<h2>게시글 목록보기</h2>
<h3>게시물 수 : <%=totalCount%></h3>
<c:set var="searchField" value="<%=searchField%>"/>
<c:set var="searchWord" value="<%=searchWord%>"/>
<c:set var="productList" value="<%=productDTOList%>"/>
<form method="get">
  <table>
    <tr>
      <td align="center">
        <select name="searchField">
          <c:choose>
            <c:when test="${searchField == 'description'}">
              <option value="pname">상품명</option>
              <option value="description" selected>상품내용</option>
            </c:when>
            <c:otherwise>
              <option value="pname" selected>상품명</option>
              <option value="description">상품내용</option>
            </c:otherwise>
          </c:choose>
        </select>
        <input type="text" name="searchWord" value="${searchWord}">
        <input type="submit" value="검색">
      </td>
    </tr>
  </table>
</form>
<table border="1" width="80%">
  <tr>
    <th width="5%">번호</th>
    <th width="20%">상풍명</th>
    <th width="30%">상품설명</th>
    <th width="10%">가격</th>
    <th width="10%">수량</th>
    <th width="15%">사용자ID</th>
    <th width="10%">방문자수</th>
  </tr>

  <c:choose>
    <c:when test="${empty productList}"> <%-- if(boardDTOList.isEmpty()) { --%>
      <tr><td colspan="7" align="center">등록된 게시글이 없습니다</td></tr>
    </c:when>
    <c:otherwise> <%-- } else { --%>
      <c:forEach var="dto" items="${productList}"> <%-- for(BoardDTO dto:boardDTOList) { --%>
        <tr>
          <td>${dto.pcode}</td>
          <td><a href="view.jsp?pcode=${dto.pcode}">${dto.pname}</a></td>
          <td>${dto.description}</td>
          <td>${dto.price}</td>
          <td>${dto.amount}</td>
          <td>${dto.user_id}</td>
          <td>${dto.visitcount}</td>
        </tr>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</table>
<table border="1" width="80%">
  <tr>
    <td align="center">
      <%=ProductPage.pagingStr(totalCount, pageSize, blockSize, pageNum, request.getRequestURI())%>
    </td>
    <td align="right">
      <button type="button" onclick="location.href='write.jsp'">글쓰기</button>
    </td>
  </tr>
</table>

</body>
</html>
