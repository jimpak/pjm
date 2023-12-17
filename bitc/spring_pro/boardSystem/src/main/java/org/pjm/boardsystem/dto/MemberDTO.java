package org.pjm.boardsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDTO {
    private String username;
    private String password;
    private String name;
    private String nick;
    private Date regidate;
}
