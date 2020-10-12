package com.example.casestudy.service.logcomment;

import com.example.casestudy.model.LogComment;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogCommentService {
    LogComment saveLogComment(LogComment logComment);

    Iterable<LogComment> findAllLogCommentByCommentId(Long commentId);
}
