package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model2.member.MemberDAO;
import model2.member.MemberDTO;
import utils.JSFunction;

import java.io.IOException;

@WebServlet("/member/join.do")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("user_id");
        String pass = req.getParameter("user_pass");
        String name = req.getParameter("user_name");

        MemberDTO dto = new MemberDTO();
        dto.setId(id);
        dto.setPass(pass);
        dto.setUser_name(name);

        MemberDAO dao = new MemberDAO();
        int iResult = dao.insertRegister(dto);
        dao.close();

        if(iResult == 1) {
            JSFunction.alertLocation(resp, "회원가입에 성공하셨습니다.", "/member/login.do");
        } else {
            JSFunction.alertBack(resp, "회원가입에 실패하였습니다.");
        }
    }
}
