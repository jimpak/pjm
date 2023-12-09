package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model2.member.MemberDAO;
import model2.product.ProductDAO;
import model2.product.ReplyDTO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/product/reply.do")
public class ReplyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rnum = Integer.parseInt(req.getParameter("rnum"));
        ProductDAO dao = new ProductDAO();
        int result = dao.replyDelete(rnum);
        dao.close();

        PrintWriter out = resp.getWriter();
        if(result == 1) {
            out.print("success");
        } else {
            out.print("fail");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        ReplyDTO dto = new ReplyDTO();
        dto.setPcode(Integer.parseInt(req.getParameter("pcode")));
        dto.setUser_id(userId);
        dto.setContent(req.getParameter("content"));

        ProductDAO dao = new ProductDAO();
        int result = dao.insertReply(dto);
        dao.close();

        PrintWriter out = resp.getWriter();
        if(result == 1) {
            MemberDAO mdao = new MemberDAO();
            mdao.mileageUpReply(userId);
            mdao.close();
            out.print("success");
        } else {
            out.print("fail");
        }
    }
}
