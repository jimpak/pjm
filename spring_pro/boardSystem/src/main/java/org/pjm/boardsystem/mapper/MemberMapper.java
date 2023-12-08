package org.pjm.boardsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pjm.boardsystem.vo.MemberVO;

import java.util.List;

@Mapper
public interface MemberMapper {
    int insertMember(MemberVO vo);
    int updateMember(MemberVO vo);
    int deleteMember(String username);
    MemberVO readMember(String username);
    List<MemberVO> getMemberList();
    int conformUsername(String username);
    int conformNickname(String nickname);

}
