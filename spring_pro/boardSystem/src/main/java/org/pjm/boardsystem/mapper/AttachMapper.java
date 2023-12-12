package org.pjm.boardsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pjm.boardsystem.vo.BoardAttachVO;

import java.util.List;

@Mapper
public interface AttachMapper {
    void insertAttach(BoardAttachVO vo);
    void deleteAttach(String uuid);
    List<BoardAttachVO> findByBno(int bno);
    void deleteAll(int bno);
    public List<BoardAttachVO> getOldFiles();

}
