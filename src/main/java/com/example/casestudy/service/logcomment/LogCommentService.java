package com.example.casestudy.service.logcomment;

import com.example.casestudy.model.LogComment;
import com.example.casestudy.repository.ILogCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogCommentService implements ILogCommentService{
    @Autowired
    private ILogCommentRepository logCommentRepository;

    @Override
    public LogComment saveLogComment(LogComment logComment) {
        logCommentRepository.save(logComment);
        return logCommentRepository.findById(logComment.getCommentId()).get();
    }

    @Override
    public Iterable<LogComment> findAllLogCommentByCommentId(Long commentId) {
        return logCommentRepository.findAllByCommentId(commentId);
    }

}
