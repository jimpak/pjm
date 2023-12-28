package com.example.sb02.repository;

import com.example.sb02.model.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class RepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Board board = Board.builder().title("title.." + i).content("content.." + i).writer("user" + i).build();
            Board result = boardRepository.save(board);
            log.info(result);
        });
    }

    @Test
    public void testSelect() {
        Long bno = 298L;

        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        log.info(board);
    }

    @Test
    public void testUpdate() {
        Long bno = 1L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        board.change("update_title..1", "update_content..2", "user01");
        Board board1 = boardRepository.save(board);
        log.info(board1);
    }

    @Test
    public void testDelete() {
        Long bno = 100L;
        boardRepository.deleteById(bno);
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.findByTitleContainingOrderByBnoDesc("1", pageable);
        log.info("total count:" + result.getTotalElements());
        log.info("total page:" + result.getTotalPages());
        log.info("page num:" + result.getNumber());
        log.info("page size:" + result.getSize());
        List<Board> boardList = result.getContent();
        boardList.forEach(board -> {
            log.info(board);
        });
    }

    @Test
    public void testPaging1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.findByKeyword("1", pageable);
        log.info("total count:" + result.getTotalElements());
        log.info("total page:" + result.getTotalPages());
        log.info("page num:" + result.getNumber());
        log.info("page size:" + result.getSize());
        List<Board> boardList = result.getContent();
        boardList.forEach(board -> {
            log.info(board);
        });
    }

    @Test
    public void testSearch1() {
        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.search1(pageable);
        log.info("total page:" + result.getTotalPages());
        log.info(("total count:" + result.getNumberOfElements()));
        log.info("page size:" + result.getSize());
        log.info("page number:" + result.getNumber());
        log.info(result.hasPrevious() + ":" + result.hasNext());
        result.getContent().forEach(board -> {
            log.info(board);
        });
    }

    @Test
    public void searchAll() {
        String[] types = {"t", "c", "w"};
        String keyword = "9";

        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);

        log.info("total page:" + result.getTotalPages());
        log.info("total count:" + result.getTotalElements());
        log.info("page size:" + result.getSize());
        log.info("pageNumber:" + result.getNumber());
        log.info(result.hasPrevious() + ":" + result.hasNext());
        result.getContent().forEach(board -> {
            log.info(board);
        });

    }

}
