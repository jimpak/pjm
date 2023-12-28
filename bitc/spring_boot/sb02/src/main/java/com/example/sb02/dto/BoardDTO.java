package com.example.sb02.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    @NotEmpty
    @Size(min=3, max=100)
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;
    private Long visitcount;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private List<MultipartFile> files;

}
