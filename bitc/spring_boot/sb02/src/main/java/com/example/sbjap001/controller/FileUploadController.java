package com.example.sbjap001.controller;

import com.example.sbjap001.domain.FileModel;
import com.example.sbjap001.dto.upload.UploadFileDTO;
import com.example.sbjap001.dto.upload.UploadResultDTO;
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

@Controller
@Log4j2
@RequestMapping("/upload")
public class FileUploadController {
    //application.properties에 설정된 uploadPath
    @Value("${com.example.sbjap001.upload.path}")
    private String uploadPath;  //d:\\upload

    @GetMapping("/uploadForm")
    public void uploadForm(){

    }
    @PostMapping(value="/uploadPro", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(UploadFileDTO uploadFileDTO, Model model){
        log.info(uploadFileDTO.getTitle());
        log.info(uploadFileDTO.getContent());

        if(uploadFileDTO.getFiles() !=null){
            final List<UploadResultDTO> list=new ArrayList<>();
//            for(int i=0; i<upload.getFiles().size();i++){
//
//            }
            uploadFileDTO.getFiles().forEach(multipartFile -> {
                String originalFileName=multipartFile.getOriginalFilename();
                log.info(originalFileName);
                //uploadPath=uploadPath+"\\"+getFolder();
                String uuid= UUID.randomUUID().toString();
                Path savePath= Paths.get(uploadPath, uuid+"_"+originalFileName);
                boolean image=false;

                try{
                    multipartFile.transferTo(savePath);
                    if(Files.probeContentType(savePath).startsWith("image")){
                        image=true;
                        File thumbFile=new File(uploadPath, "s_"+uuid+"_"+originalFileName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile,200,200);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
                FileModel fileModel=FileModel.builder().filename(originalFileName)
                                .image(image)
                                        .uuid(uuid).build();

                //Long fno=filModeService.register(fileModel);

                list.add(UploadResultDTO.builder()
                                .uuid(uuid)
                                .filename(originalFileName)
                                .image(image).build()
                );
            });
            model.addAttribute("fileList",list);
        }
    }

    @GetMapping("/display/{fileName}")
    public ResponseEntity<Resource> disply(@PathVariable("fileName") String fileName){
        Resource resource=new FileSystemResource(uploadPath+File.separator+fileName);
        String resourceName=resource.getFilename();
        HttpHeaders headers=new HttpHeaders();

        try{
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

}
