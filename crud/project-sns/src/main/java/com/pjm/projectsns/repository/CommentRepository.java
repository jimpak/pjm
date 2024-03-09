package com.pjm.projectsns.repository;

import com.pjm.projectsns.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
