package org.pjm.boardsystem.service;

import org.pjm.boardsystem.dto.MemberDTO;
import org.pjm.boardsystem.dto.ReplyDTO;

public interface MemberService {
    int join(MemberDTO dto);
    int modify(MemberDTO dto);
    int remove(String username);
    boolean conformUsername(String username);
}
