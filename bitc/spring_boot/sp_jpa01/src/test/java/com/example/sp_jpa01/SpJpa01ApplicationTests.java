package com.example.sp_jpa01;

import com.example.sp_jpa01.model.Board;
import com.example.sp_jpa01.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
class SpJpa01ApplicationTests {

	@Autowired
	BoardService boardService;

	@Test
	void insertTest() throws Exception {
		Board board = new Board();
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("user00");
		log.info(boardService.register(board));
	}

	@Test
	void list() throws Exception {
		List<Board> list = boardService.getList();
		list.forEach(board -> {
			log.info(board);
		});
	}

}
