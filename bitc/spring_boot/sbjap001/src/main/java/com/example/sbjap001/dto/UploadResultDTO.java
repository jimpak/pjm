package com.example.sbjap001.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO {
    private String uuid;
    private String filename;
    private boolean image;

    public String getLink() {
        if(image)
            return "s_" + uuid + "_" + filename;
        else
            return uuid + "_" + filename;
    }
}
