package com.example.casestudy.service.comment;

import com.example.casestudy.model.Comment;
import com.example.casestudy.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        commentRepository.save(comment);
        return commentRepository.findById(comment.getCommentId()).get();
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Iterable<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findCommentByCommentId(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Iterable<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    @Override
    public Iterable<Comment> findCommentByCommenterId(Long userId) {
        return commentRepository.findCommentsByCommenterId(userId);
    }
}
