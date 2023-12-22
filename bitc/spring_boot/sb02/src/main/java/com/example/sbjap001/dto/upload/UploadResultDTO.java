package com.example.sbjap001.dto.upload;

import com.example.sbjap001.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO extends BaseEntity {
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
