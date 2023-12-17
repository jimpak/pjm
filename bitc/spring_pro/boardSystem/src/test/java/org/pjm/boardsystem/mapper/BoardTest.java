package org.pjm.boardsystem.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardTest {
    @Autowired(required = false)
    private BoardMapper boardMapper;
    @Autowired(required = false)
    private BoardService boardService;

    @Test
    public void testGetTime(){
        log.info(boardMapper.getTime());
    }

    @Test
    public void testList() throws Exception {
        List<BoardDTO> boardDTOList = boardService.getList();
        boardDTOList.forEach(board->{
            log.info(board);
        });
    }

    @Test
    public void testInsert() throws Exception {
        BoardDTO dto = new BoardDTO();
        dto.setTitle("title3");
        dto.setContent("content3");
        dto.setWriter("user02");
        dto.setPostdate(LocalDate.now());
        int result = boardService.register(dto);
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + result);
    }

}
