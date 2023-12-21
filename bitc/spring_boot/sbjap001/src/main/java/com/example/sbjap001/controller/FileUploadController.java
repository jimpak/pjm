package com.example.sbjap001.controller;

import com.example.sbjap001.domain.UploadFile;
import com.example.sbjap001.dto.UploadFileDTO;
import com.example.sbjap001.dto.UploadResultDTO;
import com.example.sbjap001.repository.UploadFileRepository;
import com.example.sbjap001.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j2
@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploadController {

    private final UploadFileService uploadFileService;

    @Value("${com.example.sbjap001.upload.path}")
    private String uploadPath;

    @GetMapping("/uploadForm")
    public void uploadForm() {

    }

    @PostMapping(value = "/uploadPro", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(UploadFileDTO uploadFileDTO, Model model) {
        log.info("title = " + uploadFileDTO.getTitle());
        log.info("content = " + uploadFileDTO.getContent());

        if (uploadFileDTO.getFiles() != null) {
            final List<UploadResultDTO> list = new ArrayList<>();

            uploadFileDTO.getFiles().forEach(multipartFile -> {
                String originalName = multipartFile.getOriginalFilename();
                log.info(originalName);
//                uploadPath = uploadPath + "\\" + getFolder();
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);
                boolean image = false;
                try {
                    multipartFile.transferTo(savePath);
                    if (Files.probeContentType(savePath).startsWith("image")) {
                        image = true;
                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originalName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                UploadFile uploadFile = UploadFile.builder()
                        .filename(originalName)
                        .image(image)
                        .uuid(uuid)
                        .build();
                Long fno = uploadFileService.register(uploadFile);

                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .filename(originalName)
                        .image(image).build());
            });
            model.addAttribute("fileList", list);
        }
    }

    @GetMapping("/display/{fileName}")
    public ResponseEntity<Resource> display(@PathVariable("fileName") String fileName) {
        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().headers(headers).body(resource);
    }


}
