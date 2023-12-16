package org.pjm.boardsystem.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.pjm.boardsystem.dto.AttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Log4j2
@Controller
//@MultipartConfig(
//        location = "c:/upload/temp",
//        maxFileSize = 1024*1024*10, //10GB
//        maxRequestSize = 1024*1024*20,
//        fileSizeThreshold = 1024*1024*10
//)
@RequestMapping("/upload")
public class FileUploadController {

    String uploadFolder = "c:/upload";

    @GetMapping("/uploadForm")
    public void uploadFormGet() {

    }

    @PostMapping("/uploadForm")
    public void uploadFormPost(MultipartFile[] uploadFile) {
        for(MultipartFile multipartFile : uploadFile) {
            log.info("----------------------------------------");
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            log.info("Upload File Size : " + multipartFile.getSize());

            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
            try {
                multipartFile.transferTo(saveFile);

            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/uploadAjax")
    public void uploadAjaxGet() {

    }

    @PostMapping("/uploadAjax")
    @ResponseBody
    public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
        List<AttachFileDTO> dtoList = new ArrayList<>();
        String uploadFolderPath = getFolder(); // yyyy/mm/dd => 2023/12/11
        log.info("uploadFolderPath = " + uploadFolderPath);
        File uploadPath = new File(uploadFolder, uploadFolderPath); //c:/upload/yyyy/mm/dd
        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        for(MultipartFile multipartFile : uploadFile) {
            AttachFileDTO attachFileDTO = new AttachFileDTO();

            log.info("----------------------------------------");
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            log.info("Upload File Size : " + multipartFile.getSize());

            String uploadFileName = multipartFile.getOriginalFilename();
            attachFileDTO.setFilename(uploadFileName);
            UUID uuid = UUID.randomUUID();
            uploadFileName = uuid.toString() + "_" + uploadFileName;

//            File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());
            File saveFile = new File(uploadPath, uploadFileName);
            try {
                multipartFile.transferTo(saveFile);
                attachFileDTO.setUuid(uuid.toString());
                attachFileDTO.setUploadpath(uploadFolderPath);

                // check image type file
                if(checkImageType(saveFile)) {
                    FileOutputStream thumnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumnail, 100, 100);
                    thumnail.close();

                    attachFileDTO.setImage(true);
                }

                dtoList.add(attachFileDTO);

            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName) {
        log.info("Original fileName : " + fileName);
        File file = new File("c:\\upload\\" + fileName);
//        File file = new File(uploadFolder, fileName);
        ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, @RequestParam("fileName") String fileName) {
        log.info("download file: " + fileName);
        Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
        if (resource.exists() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("resource: " + resource);
        String resourceName = resource.getFilename();
        String resourceOriginalName=resourceName.substring(resourceName.lastIndexOf("_")+1);
        HttpHeaders headers = new HttpHeaders();
        try {
            //headers.add("Content-Disposition","attachment; filename=" +
            //new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
            String downloadName = null;

            if (userAgent.contains("Trident")) {
                log.info("IE browser");
                downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8")
                        .replaceAll("\\+", " ");
            }else if(userAgent.contains("Edge")) {
                log.info("Edge browser");
                downloadName =  URLEncoder.encode(resourceOriginalName,"UTF-8");
            }else {
                log.info("Chrome browser");
                downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
            }

            log.info("downloadName: " + downloadName);

            headers.add("Content-Disposition", "attachment; filename=" + downloadName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/deleteFile")
    @ResponseBody
    public ResponseEntity<String> deleteFile(String fileName, String type) {
        log.info("deleteFile: " + fileName);
        File file;
        try { //원본파일 삭제
            file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
            file.delete();
            if (type.equals("image")) { //이미지 파일 Thumbnail 파일도 함께 삭제
                String largeFileName = file.getAbsolutePath().replace("s_", ""); // getAbsolutePath : 파일의 절대 경로
                log.info("largeFileName: " + largeFileName);
                file = new File(largeFileName);
                file.delete();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }



        // yyyy/mm/dd => 2023/12/11
    private String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = sdf.format(date);
        return str.replace("-", File.separator);
    }

    private boolean checkImageType(File file) {
        try {
            String contentType = Files.probeContentType(file.toPath());
            log.info("contentType = " + contentType);
            return contentType.startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

