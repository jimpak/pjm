package com.pjm.project03_spring.controller;

import com.pjm.project03_spring.model.Diary;
import com.pjm.project03_spring.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary/*")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;


    // 전체보기


    // 추가
    @PostMapping("insert")
    public Diary insert (@RequestBody Diary diary) {
        return diaryService.insert(diary);
    }
}
