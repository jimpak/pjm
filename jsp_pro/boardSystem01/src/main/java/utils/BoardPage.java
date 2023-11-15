package utils;

public class BoardPage {
    public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
        String pagingStr = "";
        // 전체 페이지 수
        int totalPages = (int)(Math.ceil((double)totalCount/pageSize));

        // 이전 페이지 블록 바로가기 출력
        int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
        if(pageTemp != 1) {
            pagingStr += "<a href='" + reqUrl + "?pageNum=1'>[첫 페이지]</a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageTemp - 1) + "'>[이전블록]</a>";
        }

        return pagingStr;
    }
}
