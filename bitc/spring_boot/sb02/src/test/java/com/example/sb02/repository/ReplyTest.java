package com.example.sb02.repository;

import com.example.sb02.dto.BoardListReplyCountDTO;
import com.example.sb02.model.Board;
import com.example.sb02.model.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Log4j2
public class ReplyTest {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Test
    public void testInsert(){
        Long bno = 298l;
        Board board = Board.builder().bno(bno).build();
        Reply reply = Reply.builder().board(board).replytext("댓글내용을 입력").replyer("replyer3").build();
        replyRepository.save(reply);
    }
    @Test
    public void testRepliesSelect(){
        Long bno = 298l;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);
        result.forEach(reply -> {
            log.info(reply);
        });
    }
    @Test
    public void testSelectReplyCount(){
        String[] types={"t","c","w"};
        String keyword = "6";
        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types,keyword,pageable);
        log.info(result.getTotalElements());
        log.info(result.getTotalPages());
        log.info(result.getSize());
        log.info(result.getNumber());
        log.info(result.hasPrevious()+":"+result.hasNext());
        result.getContent().forEach(board->{
            log.info(board);
        });
    }
}
