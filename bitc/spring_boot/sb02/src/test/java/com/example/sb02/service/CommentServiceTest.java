package com.example.sb02.service;

import com.example.sb02.dto.CommentRequestDTO;
import com.example.sb02.dto.CommentResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void commentInsertTest() {
        commentService.create(new CommentRequestDTO("content", "user00", 1L, 1L));
    }

    @Test
    public void commentListTest() {
        List<CommentResponseDTO> list = commentService.findAll(1L);
        list.forEach(commentResponseDTO ->
                log.info(commentResponseDTO));
    }

}
