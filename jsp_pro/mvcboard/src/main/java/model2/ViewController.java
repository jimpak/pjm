package model2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MVCBoardDAO dao = new MVCBoardDAO();
        int idx = Integer.parseInt(req.getParameter("idx"));
        dao.updateVisitCount(idx);
        MVCBoardDTO dto = dao.selectView(idx);
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
        req.setAttribute("dto", dto);
        req.setAttribute("isImg", isImage);
        req.getRequestDispatcher("/board/view.jsp").forward(req, resp);
    }
}
