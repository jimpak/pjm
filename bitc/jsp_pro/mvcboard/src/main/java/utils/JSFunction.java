package utils;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;

import java.io.PrintWriter;

public class JSFunction {
    public static void alertLocation(HttpServletResponse resp, String msg, String url) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            // 삽입할 자바스크립트 코드
            String script = "<script>"
                    + " alert('" + msg + "');"
                    + " location.href = '" + url + "';"
                    +"</script>";
            // out 내장객체로 출력(삽입)
            out.println(script);

        } catch (Exception e) {

        }

    }

    public static void alertBack(HttpServletResponse resp, String msg) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();

            String script = "<script>"
                    + " alert('" + msg + "');"
                    + " history.back();"
                    +"</script>";

            out.println(script);

        } catch (Exception e) {

        }
    }
}
