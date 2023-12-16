<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>1. 쿠키 설정</h2>
<%
    Cookie cookie = new Cookie("myCookie", "쿠키1"); // 쿠키 생성
    cookie.setPath(request.getContextPath()); // 경로를 컨텍스트 루트로 설정
    cookie.setMaxAge(3600); // 유지 기간을 1시간으로 설정
    Cookie cookie2 = new Cookie("myCookie2", "쿠키2");
    response.addCookie(cookie); // 응답 헤더에 쿠키 추가
    response.addCookie(cookie2);
%>
<h2>2. 쿠키 설정정보 확인</h2>
<%
    Cookie[] cookies = request.getCookies(); // 요청 헤더의 모든 쿠키 얻기
    if(cookies != null) {
        for(Cookie c: cookies) { // 쿠키 각각의..
            String cookieName = c.getName(); // 쿠키 이름 얻기
            String cookieValue = c.getValue(); // 쿠키 값 얻기
            String cookiePath = c.getPath();
            int cookieTime = c.getMaxAge();
            out.println(cookieName + " : " + cookieValue + "<br>");
            out.print(cookiePath + "<br>");
            out.println(cookieTime + "<br>");
            out.println();
        }
    }
%>
<h2>쿠키 생성 후 다른 페이지에서 확인하기</h2>
<a href="aaaa.jsp">aaaa.jsp로 이동</a>
</body>
</html>
