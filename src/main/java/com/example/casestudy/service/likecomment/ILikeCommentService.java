package com.example.casestudy.service.likecomment;

import com.example.casestudy.model.LikeComment;

public interface ILikeCommentService {
    LikeComment saveLikeComment(LikeComment likeComment);

    void deleteLikeComment(Long id);

    Iterable<LikeComment> findAllLikeComment();

    LikeComment findLikeCommentById(Long id);
}
