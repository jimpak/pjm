package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model2.product.ProductDAO;
import model2.product.ProductDTO;
import model2.product.ReplyDTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();
        int pcode = Integer.parseInt(req.getParameter("pcode"));
        dao.updateVisitCount(pcode);
        ProductDTO dto = dao.selectView(pcode);

        List<ReplyDTO> replyDTOList = dao.selectListReply(pcode);
        dao.close();

        String ext = null;
        String fileName = dto.getSfile();
        if(fileName != null) {
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        String[] mimeStr = {"png", "jpg", "gif", "PNG", "JPG", "GIF"};
        List<String> mimeList = Arrays.asList(mimeStr);
        boolean isImage = false;
        if(mimeList.contains(ext)) {
            isImage = true;
        }
        req.setAttribute("replyList", replyDTOList);
        req.setAttribute("dto", dto);
        req.setAttribute("isImg", isImage);
        req.getRequestDispatcher("/product/view.jsp").forward(req, resp);
    }
}
