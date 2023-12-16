package org.pjm.boardsystem.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pjm.boardsystem.dto.MemberDTO;
import org.pjm.boardsystem.dto.ReplyDTO;
import org.pjm.boardsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MemberTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void testInsert() throws Exception {
        MemberDTO dto = new MemberDTO();
        dto.setUsername("abcd");
        dto.setPassword("1234");
        dto.setName("홍길동");
        dto.setNick("조선제일검");
        memberService.join(dto);
    }

    @Test
    public void testUpdate() throws Exception {
        MemberDTO dto = new MemberDTO();
        dto.setPassword("asdf");
        memberService.modify(dto);
    }
}
