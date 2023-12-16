package org.pjm.springexam03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {
    private int idx;
    private String name;
    private int age;
    private String phone;
    private Date postdate;
}
