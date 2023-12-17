package com.example.restex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Log4j2
@RequestMapping("/upload")
@Controller
public class FileController {

    private String uploadFolder = "c:/upload/temp";

    @GetMapping("/uploadForm")
    public String uploadGet() {
        return "/upload/uploadForm";
    }

    @PostMapping("/uploadAction")
    public String uploadPost(MultipartFile ofile, Model model) {
        log.info(ofile.getOriginalFilename());
        log.info(ofile.getSize());
        File saveFile = new File(uploadFolder, ofile.getOriginalFilename());
        try {
            ofile.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/upload/result";
    }

    @PostMapping("/uploadActions")
    public String uploadPost(MultipartFile[] ofiles, Model model) {
        for(MultipartFile multipartFile : ofiles) {
            log.info(multipartFile.getOriginalFilename());
            log.info(multipartFile.getSize());
            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
            try {
                multipartFile.transferTo(saveFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "/upload/result";
    }
}
