package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model2.product.ProductDAO;
import utils.JSFunction;

import java.io.IOException;

@WebServlet("/product/delete.do")
public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pcode = Integer.parseInt(req.getParameter("pcode"));
        ProductDAO dao = new ProductDAO();
        int iResult = dao.deletePost(pcode);
        if(iResult == 1) {
            JSFunction.alertLocation(resp, "해당 게시물이 정상적으로 삭제되었습니다", "/product/list.do");
        } else {
            JSFunction.alertBack(resp, "삭제 실패");
        }

    }
}
