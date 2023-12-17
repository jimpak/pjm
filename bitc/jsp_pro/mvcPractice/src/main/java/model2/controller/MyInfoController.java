package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model2.member.MemberDAO;
import model2.member.MemberDTO;

import java.io.IOException;

@WebServlet("/member/info.do")
public class MyInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id");
        MemberDAO dao = new MemberDAO();
        System.out.println("userId");
        MemberDTO dto = dao.selectInfo(userId);

        req.setAttribute("dto", dto);

        dao.close();

        req.getRequestDispatcher("/member/info.jsp").forward(req, resp);
    }

}
