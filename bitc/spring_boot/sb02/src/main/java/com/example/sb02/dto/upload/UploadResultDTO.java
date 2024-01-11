package com.example.sb02.dto.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UploadResultDTO {
    private String uuid;
    private String filename;
    private boolean image;
    public String getLink(){
        if(image){
            return "s_"+uuid+"_"+filename;
        }else{
            return uuid+"_"+filename;
        }
    }
}