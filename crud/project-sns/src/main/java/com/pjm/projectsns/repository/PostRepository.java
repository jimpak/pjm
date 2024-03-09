package com.pjm.projectsns.repository;

import com.pjm.projectsns.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
