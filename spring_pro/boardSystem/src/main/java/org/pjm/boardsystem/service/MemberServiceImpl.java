package org.pjm.boardsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.pjm.boardsystem.dto.MemberDTO;
import org.pjm.boardsystem.mapper.MemberMapper;
import org.pjm.boardsystem.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;


    @Override
    public int join(MemberDTO dto) {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberMapper.insertMember(vo);
        return result;
    }

    @Override
    public int modify(MemberDTO dto) {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberMapper.updateMember(vo);
        return result;
    }

    @Override
    public int remove(String username) {
        return memberMapper.deleteMember(username);
    }

    @Override
    public boolean conformUsername(String username) {
        int result = memberMapper.selectMember(username);
        return result;
    }
}
