package com.example.casestudy.service.likepost;

import com.example.casestudy.model.LikePost;
import com.example.casestudy.repository.ILikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikePostService implements ILikePostService{
    @Autowired
    ILikePostRepository likePostRepository;

    @Override
    public LikePost saveLikePost(LikePost LikePost) {
        return likePostRepository.save(LikePost);
    }

    @Override
    public void deleteLikePost(Long id) {
        likePostRepository.deleteById(id);
    }

    @Override
    public Iterable<LikePost> findAllLikePost() {
        return likePostRepository.findAll();
    }

    @Override
    public LikePost findLikePostById(Long id) {
        return likePostRepository.getOne(id);
    }
}
