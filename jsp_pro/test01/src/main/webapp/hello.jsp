<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
String s1 = "jsp";
String s2 = "안녕하세요";
%>

<body>
	<h2>처음 만들어 보는 <%=s1 %></h2>
	<%
	out.println(s2 + ", 열공입니다!!" + "<br>");
	
	int result = 0;
	int a = 10;
	int b = 20;
	덧셈결과 : out.println(a+b + "<br>");
	뺄셈결과 : out.println(a-b + "<br>");
	if(a % 2 == 0) {
		out.println("짝수입니다." + "<br>");
	} else {
		out.println("홀수입니다." + "<br>");
	}
	
	for(int i = 0; i <= 10; i++) {
		out.println(i + "<br>");
	}
	%>
	<br><br><br>
	<%
	a = 6;
	b = 5;
	덧셈결과 : out.println(a+b);
	%><br><%
	뺄셈결과 : out.println(a-b);
	%><br><%
	if(a % 2 == 0) {
		out.println("짝수.");
	} else {
		out.println("홀수입니다.");
	}
	%>
</body>
</html>