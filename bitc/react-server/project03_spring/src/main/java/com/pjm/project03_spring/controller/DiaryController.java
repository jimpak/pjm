package com.pjm.project03_spring.controller;

import com.pjm.project03_spring.model.Diary;
import com.pjm.project03_spring.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary/*")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;


    // 전체보기
    @GetMapping("list")
    public List<Diary> list() {
        return diaryService.findAll();
    }

    // 추가
    @PostMapping("insert")
    public Diary insert (@RequestBody Diary diary) {
        return diaryService.insert(diary);
    }

    @PutMapping("update/{id}")
    public Diary update (@PathVariable Long id, @RequestBody Diary diary) {
        return diaryService.update(diary);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        diaryService.delete(id);
    }
}
