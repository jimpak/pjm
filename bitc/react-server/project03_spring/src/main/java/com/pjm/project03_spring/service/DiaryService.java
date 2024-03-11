package com.pjm.project03_spring.service;

import com.pjm.project03_spring.model.Diary;
import com.pjm.project03_spring.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    // 전체보기
    
    //추가
    public Diary insert(Diary diary) {
        return diaryRepository.save(diary);
    }
}
