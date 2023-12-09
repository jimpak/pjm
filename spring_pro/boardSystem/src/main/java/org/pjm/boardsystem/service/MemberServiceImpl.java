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

//    @Override
//    public boolean conformUsername(String username) {
//        int count = memberMapper.conformUsername(username);
//        if(count>0)
//            return true;
//        return false;
//    }
//
//    @Override
//    public boolean conformNickname(String nickname) {
//        int count = memberMapper.conformNickname(nickname);
//        if(count>0)
//            return true;
//        return false;
//    }

    @Override
    public int conformUsername(String username) {
        return memberMapper.conformUsername(username);
    }

    @Override
    public int conformNickname(String nickname) {
        return memberMapper.conformNickname(nickname);
    }

    @Override
    public MemberDTO get(String username) {
        return null;
    }

    @Override
    public MemberDTO loginPro(String username, String password) {
        MemberVO vo = memberMapper.readMember(username);
        if(vo.getPassword().equals(password)) {
            MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
            return dto;
        }
        return null;
    }
}
