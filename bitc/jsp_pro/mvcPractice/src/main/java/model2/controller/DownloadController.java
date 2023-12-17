package model2.controller;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model2.product.ProductDAO;

import java.io.IOException;

@WebServlet("/product/download.do")
public class DownloadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ofile = req.getParameter("ofile");
        String sfile = req.getParameter("sfile");
        int idx = Integer.parseInt(req.getParameter("idx"));

        FileUtil.download(req, resp, "/uploads", sfile, ofile);
        ProductDAO dao = new ProductDAO();
        dao.downCountPlus(idx);
        dao.close();
    }
}
