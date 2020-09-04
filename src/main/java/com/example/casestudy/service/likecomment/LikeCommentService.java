package com.example.casestudy.service.likecomment;

import com.example.casestudy.model.LikeComment;
import com.example.casestudy.repository.ILikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeCommentService implements ILikeCommentService {

    @Autowired
    ILikeCommentRepository likeCommentRepository;


    @Override
    public LikeComment saveLikeComment(LikeComment likeComment) {
        return likeCommentRepository.save(likeComment);
    }

    @Override
    public void deleteLikeComment(Long id) {
        likeCommentRepository.deleteById(id);
    }

    @Override
    public Iterable<LikeComment> findAllLikeComment() {
        return likeCommentRepository.findAll();
    }

    @Override
    public LikeComment findLikeCommentById(Long id) {
        return likeCommentRepository.getOne(id);
    }
}
