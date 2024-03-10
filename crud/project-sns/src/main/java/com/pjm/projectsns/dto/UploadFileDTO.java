package com.pjm.projectsns.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class UploadFileDTO {

    private String title;
    private String content;
    private List<MultipartFile> files;
    private Long postId; // Movie 엔티티의 ID

    // Post 엔티티의 ID를 받아서 설정하는 메서드
    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
