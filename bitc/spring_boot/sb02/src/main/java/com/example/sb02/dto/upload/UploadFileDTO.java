package com.example.sb02.dto.upload;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data @Builder
public class UploadFileDTO {
    private String title;
    private String content;
//    private String filename;
    private List<MultipartFile> files;
}
