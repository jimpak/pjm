package org.pjm.boardsystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1) // 최소값
    @Positive // 양수만 가능
    private int page = 1; // 첫 페이지

    @Builder.Default
    @Min(value = 3)
    @Max(value = 100)
    @Positive
    private int size = 3; // 페이지 범위
    // min, size값 같아야함.

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;


    public int getSkip() {
        return (page - 1) * 3;
    }

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        // 제목 or 내용
        if(types != null && types.length > 0) {
            for(int i = 0; i < types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }

        // 검색 키워드
        if(keyword != null) {
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException uee) {
                uee.printStackTrace();
            }
        }

        // 날짜
        if(from != null) {
            builder.append("&from=" + from.toString());
        }

        // 날짜
        if(to != null) {
            builder.append("&to=" + to.toString());
        }

        return builder.toString();
    }

    public boolean checkType(String type) {
        if(types == null || types.length == 0) {
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }

}
