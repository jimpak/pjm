package org.pjm.boardsystem.service;

import org.pjm.boardsystem.dto.MemberDTO;
import org.pjm.boardsystem.dto.ReplyDTO;

public interface MemberService {
    int join(MemberDTO dto);
    int modify(MemberDTO dto);
    int remove(String username);
    int conformUsername(String username);
    int conformNickname(String nickname);
    MemberDTO get(String username);

    MemberDTO loginPro(String username, String password);
}
