package org.pjm.boardsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.dto.PageRequestDTO;
import org.pjm.boardsystem.vo.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {
    void updateReplycount(@Param("bno") int bno, @Param("amount") int amount);
    List<BoardVO> pagingList(PageRequestDTO pageRequestDTO);
    int pageCount(PageRequestDTO pageRequestDTO);
    String getTime();
    List<BoardVO> getBoardList();
    int insertBoard(BoardVO boardVO);
    BoardVO get(int bno);
    void visitcountUpdate(int bno);
    int updateBoard(BoardVO boardVO);
    int deleteBoard(int bno);
    int totalCount();
    int getBno();

}