package com.example.sb02.controller;

import com.example.sb02.dto.upload.UploadFileDTO;
import com.example.sb02.dto.upload.UploadResultDTO;
import com.example.sb02.model.UploadFile;
import com.example.sb02.service.UploadFileService;
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

@Controller
@Log4j2
@RequestMapping("/upload")
public class FileUploadController {
    // application.properties에 설정된 uploadPath
    @Value("${com.example.sb02.upload.path}")
    private String uploadPath; // d:\\upload = 이걸 변수화 했다고 보면 됨

    @GetMapping("/uploadForm")
    public void uploadForm() {
    }

    @PostMapping(value = "/uploadPro", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(UploadFileDTO uploadFileDTO, Model model) {
        log.info(uploadFileDTO.getTitle());
        log.info(uploadFileDTO.getContent());
        if (uploadFileDTO.getFiles() != null) {
            final List<UploadResultDTO> list = new ArrayList<>();
//            for(int i=0; i<uploadFileDTO.getFiles().size(); i++) for문 대신에 forEach구문을 쓴다.
            uploadFileDTO.getFiles().forEach(multipartFile -> {
                String originalFileName = multipartFile.getOriginalFilename();
                log.info(originalFileName);
//                uploadPath = uploadPath+"\\"+getFolder(); for 구문을 썼다면 이걸 추가해서 경로를 설정 (이때 getFolder() 함수를 만들어야 함)
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" + originalFileName);
                boolean image = false;

                try {
                    multipartFile.transferTo(savePath);
                    if (Files.probeContentType(savePath).startsWith("image")) {
                        image = true;
                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originalFileName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                UploadFile uploadFile= UploadFile.builder()
//                        .filename(originalFileName)
//                        .image(image)
//                        .uuid(uuid)
//                        .build();
//                Long fno = UploadFileService.register(uploadFile);
//                list.add(UploadResultDTO.builder()
//                        .uuid(uuid)
//                        .filename(originalFileName)
//                        .image(image).build());
            });
            model.addAttribute("fileList", list);
        }
    }

    @GetMapping("/disply/{fileName}")
    public ResponseEntity<Resource> disply(@PathVariable("fileName") String fileName) {
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
