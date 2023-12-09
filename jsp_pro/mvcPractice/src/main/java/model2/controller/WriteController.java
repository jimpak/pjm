package model2.controller;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model2.member.MemberDAO;
import model2.product.ProductDAO;
import model2.product.ProductDTO;
import utils.JSFunction;

import java.io.IOException;

@WebServlet("/product/write.do")
@MultipartConfig(
        maxFileSize = 1024*1024*5,
        maxRequestSize = 1024*1024*10
)
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            JSFunction.alertLocation(resp, "로그인이 필요합니다.", "/member/login.do");
            return;
        }

        req.getRequestDispatcher("/product/write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        // 1. 파일 업로드 처리
        String saveDirectory = req.getServletContext().getRealPath("/uploads");
        String originalFileName = "";

        try {
            originalFileName = FileUtil.uploadFile(req, saveDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProductDTO dto = new ProductDTO();
        dto.setUser_id(userId);
        dto.setPname(req.getParameter("pname"));
        dto.setDescription(req.getParameter("description"));
        dto.setPrice(Integer.parseInt(req.getParameter("price")));
        dto.setAmount(Integer.parseInt(req.getParameter("amount")));

        if(originalFileName != "") {
            dto.setOfile(originalFileName);
            String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
            dto.setSfile(savedFileName);
        }

        ProductDAO dao = new ProductDAO();
        int result = dao.insertProduct(dto);

        dao.close();

        if(result == 1) {
            MemberDAO mdao = new MemberDAO();
            mdao.mileageUpWrite(userId);
            mdao.close();
            resp.sendRedirect("/product/list.do");
        } else {
            JSFunction.alertLocation(resp, "글쓰기 실패", "/product/write.do");
        }

    }

}
