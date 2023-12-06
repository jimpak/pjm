package org.pjm.boardsystem.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pjm.boardsystem.dto.ReplyDTO;
import org.pjm.boardsystem.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ReplyTest {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testInsert() throws Exception {
        ReplyDTO dto = new ReplyDTO();
        dto.setReply("댓글");
        dto.setBno(15);
        dto.setReplyer("user01");
        replyService.register(dto);
    }


    @Test
    public void getListTest() throws Exception {
        List<ReplyDTO> dtoList = replyService.getList(15);
        dtoList.forEach(dto -> {log.info(dtoList);});
    }

}
