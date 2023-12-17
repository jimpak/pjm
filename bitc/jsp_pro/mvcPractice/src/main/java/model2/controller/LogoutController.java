package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // 방법 1 : session 속성 name을 제거하는 방법
        session.removeAttribute("userId");
        session.removeAttribute("userName");

        // 방법 2 : 모든 속성 한번에 삭제
        session.invalidate();

        resp.sendRedirect("/member/login.do");
    }

}
