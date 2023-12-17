package model2.controller;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model2.product.ProductDAO;
import model2.product.ProductDTO;
import utils.JSFunction;

import java.io.IOException;

@WebServlet("/product/update.do")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pcode = Integer.parseInt(req.getParameter("pcode"));
        HttpSession session = req.getSession();

        ProductDAO dao = new ProductDAO();
        ProductDTO dto = dao.selectView(pcode);
        dao.updateVisitCount(pcode);

        String sessionId = session.getAttribute("userId").toString();
        if(!sessionId.equals(dto.getUser_id())) {
            JSFunction.alertBack(resp, "작성자만 수정할 수 있습니다.");
            return;
        }

        dao.close();

        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/product/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String saveDirectory = getServletContext().getRealPath("/uploads");
        String originalFileName = "";

        try {
            originalFileName = FileUtil.uploadFile(req, saveDirectory);

        } catch (Exception e) {
            JSFunction.alertBack(resp, "파일업로드 오류");
        }

        String prevOfile = req.getParameter("prevOfile");
        String prevSfile = req.getParameter("prevSfile");

        int pcode = Integer.parseInt(req.getParameter("pcode"));
        String pname = req.getParameter("pname");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        ProductDTO dto = new ProductDTO();
        dto.setPcode(pcode);
        dto.setPname(pname);
        dto.setDescription(description);
        dto.setPrice(price);
        dto.setAmount(amount);

        if(!originalFileName.equals("")) {
            String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
            dto.setOfile(originalFileName);
            dto.setSfile(savedFileName);
            FileUtil.deleteFile(req, "/uploads", prevSfile);
        } else {
            dto.setOfile(prevOfile);
            dto.setSfile(prevSfile);
        }
        ProductDAO dao = new ProductDAO();
        int result = dao.update(dto);
        dao.close();

        if(result == 1) {
            resp.sendRedirect("/product/view.do?pcode=" + pcode);
        } else {
            JSFunction.alertLocation(resp, "데이터 업데이트 실패", "/product/view.do?pcode=" + pcode);
        }

    }
}
