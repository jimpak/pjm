package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("*.one")
public class FrontController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init() 호출");
    }

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uri = req.getRequestURI();
//        System.out.println("uri : " + uri);
//
//        int lastSlash = uri.lastIndexOf("/");
//        String commandStr = uri.substring(lastSlash);
//
//        if (commandStr.equals("/regist.one")) {
//            registFunc(req);
//        } else if (commandStr.equals("/login.one")) {
//            loginFunc(req);
//        } else if (commandStr.equals("/freeboard.one")) {
//            freeboardFunc(req);
//        }
//
//        req.setAttribute("uri", uri);
//        req.setAttribute("commandStr", commandStr);
//        req.getRequestDispatcher("/ch12/frontController.jsp").forward(req, resp);
//
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        System.out.println("Service() 호출");

        int lastSlash = uri.lastIndexOf("/");
        String commandStr = uri.substring(lastSlash);

        if (commandStr.equals("/regist.one")) {
            registFunc(req);
        } else if (commandStr.equals("/login.one")) {
            loginFunc(req);
        } else if (commandStr.equals("/freeboard.one")) {
            freeboardFunc(req);
        }
        req.setAttribute("uri", uri);
        req.setAttribute("commandStr", commandStr);
        req.getRequestDispatcher("/ch12/frontController.jsp").forward(req, resp);
    }

    void registFunc(HttpServletRequest req) {
        req.setAttribute("resultValue", "<h4>회원가입</h4>");
    }

    void loginFunc(HttpServletRequest req) {
        req.setAttribute("resultValue", "<h4>로그인</h4>");
    }

    void freeboardFunc(HttpServletRequest req) {
        req.setAttribute("resultValue", "<h4>자유게시판</h4>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() 호출");
    }
}
