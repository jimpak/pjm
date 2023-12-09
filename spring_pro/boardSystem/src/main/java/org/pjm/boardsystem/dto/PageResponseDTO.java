package org.pjm.boardsystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    private int start; // 시작 페이지
    private int end; // 끝 페이지
    private boolean prev; // 이전 페이지 존재 여부
    private boolean next; // 다음 페이지 존재 여부
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        // page가 1인 경우: 시작 페이지(start)는 1, 마지막 페이지(end)는 10
        // 1 / 10 => 0.1 => 1 => 10
        // page가 10인 경우: 시작 페이지(start)는 1, 마지막 페이지(end)는 10
        // 10 / 10 => 1.0 => 1 => 10
        // page가 11인 경우: 시작 페이지(start)는 11, 마지막 페이지(end)는 20
        // 11 / 10 => 1.1 => 2 => 20
        this.end = (int) (Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;
        int last = (int) (Math.ceil((total / (double) size)));
        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
