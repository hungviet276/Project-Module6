package com.example.casestudy.service.comment;

import com.example.casestudy.model.Comment;

public interface ICommentService {
    Comment saveComment(Comment comment);

    void deleteComment(Long id);

    Iterable<Comment> findAllComment();

    Comment findCommentByCommentId(Long id);

    Iterable<Comment> findCommentsByPostId(Long postId);

    Iterable<Comment> findCommentByCommenterId(Long userId);
}
