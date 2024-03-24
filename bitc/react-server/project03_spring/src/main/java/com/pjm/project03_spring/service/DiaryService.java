package com.pjm.project03_spring.service;

import com.pjm.project03_spring.model.Diary;
import com.pjm.project03_spring.repository.DiaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    // 전체보기
    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }
    
    // 추가
    public Diary insert(Diary diary) {
        return diaryRepository.save(diary);
    }

    // 수정
    // 더티체킹
    @Transactional
    public Diary update(Diary diary) {
        // 영속성 컨텍스트에 있는 diary 객체(수정할 객체) 가져오기
        Diary d = diaryRepository.findById(diary.getId()).get();
        // 객체 수정하기
        d.setContent(diary.getContent());
        d.setDate(diary.getDate());
        d.setEmotionId(diary.getEmotionId());
        return  d;

       // return diaryRepository.save(d);
    }

    // 삭제
    public void delete(Long id) {
        diaryRepository.deleteById(id);
    }
}
