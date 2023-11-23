package fileupload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/upload/download.do")
public class FileDownloadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String originalFileName = req.getParameter("oName");
        String saveFileName = req.getParameter("sName");

        FileUtil.download(req, resp, originalFileName, saveFileName);
    }



}
