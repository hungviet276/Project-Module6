package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "LogComment")
public class LogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logCommentId;

    private Long commentId;

    private String content;

    private String commentTime;

    public LogComment() {
    }

    public LogComment(Long logCommentId, Long commentId, String content, String commentTime) {
        this.logCommentId = logCommentId;
        this.commentId = commentId;
        this.content = content;
        this.commentTime = commentTime;
    }

    public Long getLogCommentId() {
        return logCommentId;
    }

    public void setLogCommentId(Long logCommentId) {
        this.logCommentId = logCommentId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
}
