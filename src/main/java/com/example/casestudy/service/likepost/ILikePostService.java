package com.example.casestudy.service.likepost;

import com.example.casestudy.model.LikePost;

public interface ILikePostService {
    LikePost saveLikePost(LikePost LikePost);

    void deleteLikePost(Long id);

    Iterable<LikePost> findAllLikePost();

    LikePost findLikePostById(Long id);
}
