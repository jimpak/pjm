<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String popupMode = "on"; // 레이어 팝업창 띄울지 여부
    Cookie[] cookies = request.getCookies(); // 쿠키를 읽어 popupMode값 설정
    if(cookies != null) {
        for(Cookie c : cookies) {
            String cookieName = c.getName();
            String cookieValue = c.getValue();
            if(cookieName.equals("PopupClose")) { // popupClose 쿠키가 존재하면
                popupMode = cookieValue; // popupMode값 갱신
            }
        }
    }
%>
<html>
<head>
    <title>Title</title>
    <style>
        div#popup {
            position: absolute; top: 100px; left: 50px; color: yellow;
            width: 270px; height: 100px; background-color: grey;
        }
        div#popup>div {
            position: relative; background-color: #fff; top: 0px;
            border: 1px solid cadetblue; padding: 10px; color: darkgray;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script>
        $(function() {
            $("#closeBtn").click(function() { // 닫기 버튼을 누르면 실행되는 함수
                $("#popup").hide();
                var chkVal = $("input:checkbox[id=inactiveToday]:checked").val(); // 체크여부
                if(chkVal == 1) {
                    // 다음 작업
                    $.ajax({ // 비동기 요청
                        url: './popupCookie.jsp',
                        type: 'get',
                        data: {inactiveToday:chkVal},
                        dataType: "text",
                        success: function(resData) { // 요청 성공 시 호출되는 함수
                            if (resData != '') location.reload();
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
<h2>팝업 메인 페이지</h2>
<%
    for(int i = 1; i <= 10; i++) {
        out.println("현재 팝업창은 " + popupMode + " 상태입니다.<br>");
    }

    if(popupMode.equals("on")) { // popupMode값이 on일때만 팝업창 표시
%>
<div id="popup">
    <h2 align="center">공지사항 팝업입니다</h2>
    <div align="right">
        <form name="popForm">
            <input type="checkbox" id="inactiveToday" value="1">
            하루동안 열지 않음
            <input type="button" value="닫기" id="closeBtn">
        </form>
    </div>
</div>
<%
    }
%>
</body>
</html>
