package org.pjm.boardsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String username;
    private String password;
    private String name;
    private String nick;
    private Date regidate;
}
