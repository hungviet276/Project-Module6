package com.example.casestudy.repository;

import com.example.casestudy.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> findCommentsByPostId(Long postId);

    Iterable<Comment> findCommentsByCommenterId(Long commenterId);
}
