package org.pjm.boardsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pjm.boardsystem.vo.ReplyVO;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public int insertReply(ReplyVO vo);
    public ReplyVO readReply(int rno);
    public int updateReply(ReplyVO vo);
    public int deleteReply(int rno);
    public List<ReplyVO> getListReply(int bno);
}
