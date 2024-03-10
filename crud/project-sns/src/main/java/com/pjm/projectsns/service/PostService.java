package com.pjm.projectsns.service;

import com.pjm.projectsns.dto.PostDTO;
import com.pjm.projectsns.model.Post;
import com.pjm.projectsns.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Log4j2
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public Long register(PostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);
        return postRepository.save(post).getId();
    }
}
