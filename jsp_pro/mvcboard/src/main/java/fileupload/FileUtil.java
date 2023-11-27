package fileupload;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static String uploadFile(HttpServletRequest req, String sDirectory)
        throws ServletException, IOException {

        Part part = req.getPart("ofile");
        String partHeader = part.getHeader("content-disposition");
        String[] phArr = partHeader.split("filename=");
        String originalFileName = phArr[1].trim().replace("\"", "");

        if(!originalFileName.isEmpty()) {
            part.write(sDirectory + File.separator + originalFileName);
        }
        return  originalFileName;
    }

    public static String renameFile(String sDirectory, String filename) {
        String ext = filename.substring(filename.lastIndexOf("."));
        String sname = filename.substring(0, filename.lastIndexOf("."));
        String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
        String newFileName = sname + "_" + now + ext;
        File oldFile = new File(sDirectory + File.separator + filename);
        File newFile = new File(sDirectory + File.separator + newFileName);
        oldFile.renameTo(newFile);

        return newFileName;
    }

    public static void deleteFile(HttpServletRequest req, String directory, String saveFileName) {
        String sDirectory = req.getServletContext().getRealPath(directory);
        File file = new File(sDirectory + File.separator + saveFileName);
        if(file.exists()) { // 파일이 존재하면
            file.delete();
        }
    }
}
