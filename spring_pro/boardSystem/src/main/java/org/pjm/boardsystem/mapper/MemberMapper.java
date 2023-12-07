package org.pjm.boardsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pjm.boardsystem.vo.MemberVO;

@Mapper
public interface MemberMapper {
    public int insertMember(MemberVO vo);
    public int updateMember(MemberVO vo);
    public int deleteMember(String username);
    public int selectMember(String username);
}
