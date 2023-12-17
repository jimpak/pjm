package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model2.member.MemberDAO;
import model2.member.MemberDTO;

import java.io.IOException;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id");
        String userPw = req.getParameter("user_pw");
        HttpSession session = req.getSession();

        // 회원 테이블 DAO를 통해 히원 정보 DTO 획득
        MemberDAO dao = new MemberDAO();
        MemberDTO memberDTO = dao.getMemberDTO(userId, userPw);
        dao.close();

        // 로그인 성공 여부에 따른 처리
        if(memberDTO.getId() != null && !memberDTO.getId().equals("")) {
            // 로그인 성공
            session.setAttribute("userId", memberDTO.getId());
            session.setAttribute("userName", memberDTO.getUser_name());
            resp.sendRedirect("/product/list.do");
        } else {
            // 로그인 실패
            req.setAttribute("loginErrMsg", "로그인 오류입니다.");
            req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
        }
    }
}
