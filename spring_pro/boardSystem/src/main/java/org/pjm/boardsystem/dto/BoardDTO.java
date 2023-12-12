package org.pjm.boardsystem.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pjm.boardsystem.vo.BoardAttachVO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

// view에 영향을 주는 작업을 할때 DTO 사용

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int bno;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;
    private int visitcount;
    @Future
    private LocalDate postdate;
    private int replycount;

    private List<BoardAttachVO> attachVOList;
    private MultipartFile[] uploadFile;
}
