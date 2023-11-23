package fileupload;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileUtil {
    public static String uploadFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
        Part part = req.getPart("ofile");
        String partHeader = part.getHeader("content-disposition");
        System.out.println("partHeader = " + partHeader);
        String[] phArr = partHeader.split("filename=");
        String originalFileName = phArr[1].trim().replace("\"", "");
        if(!originalFileName.isEmpty()) {
            part.write(sDirectory + File.separator + originalFileName);
        }
        return originalFileName;
    }

    public static String renameFile(String sDirectory, String filename) {
        String ext = filename.substring(filename.lastIndexOf("."));
        String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
        String newFileName = now + ext;
        File oldFile = new File(sDirectory + File.separator + filename);
        File newFile = new File(sDirectory + File.separator + newFileName);
        oldFile.renameTo(newFile);

        return newFileName;
    }

    public static void download(HttpServletRequest req, HttpServletResponse resp,
                                String oFileName, String sFileName) {

        String sDirectory = req.getServletContext().getRealPath("/uploads");

        try {
            File file = new File(sDirectory, sFileName);
            InputStream inputStream = new FileInputStream(file);

            // 한글 파일명 깨짐 방지
            String client = req.getHeader("User-Agent");
            if(client.indexOf("WOW64") == -1) {
                oFileName = new String(oFileName.getBytes("UTF-8"), "ISO-8859-1");
            } else {
                oFileName = new String(oFileName.getBytes("KSC5601"), "ISO-8859-1");
            }

            // 파일 다운로드용 응답 헤드설정
            resp.reset();
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + oFileName + "\"");
            resp.setHeader("Content-Length", "" + file.length());

            OutputStream outputStream = resp.getOutputStream();
            byte[] b = new byte[(int)file.length()];
            int readBuffer = 0;
            while((readBuffer = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, readBuffer);
            }
            inputStream.close();
            outputStream.close();

        } catch (FileNotFoundException fe) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> multipleFile(HttpServletRequest req, String saveDirectory) {
        ArrayList<String> listFileName = new ArrayList<String>();

        return listFileName;
    }
}
