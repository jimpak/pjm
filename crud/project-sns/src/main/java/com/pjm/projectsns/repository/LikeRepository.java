package com.pjm.projectsns.repository;

import com.pjm.projectsns.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
