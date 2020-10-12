package com.example.casestudy.repository;

import com.example.casestudy.model.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeCommentRepository extends JpaRepository<LikeComment,Long> {
    Iterable<LikeComment> findLikeCommentsByCommentId(Long commentId);
}
