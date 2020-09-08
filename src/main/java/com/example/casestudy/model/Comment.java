package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long commenterId;

    private Long postId;

    private String content;

    private int commentLike;

    private int commentDislike;

    private String commentTime;

    private int edited;

    public Comment() {
    }

    public Comment(Long commentId, Long commenterId, Long postId, String content, int commentLike, int commentDislike, String commentTime, int edited) {
        this.commentId = commentId;
        this.commenterId = commenterId;
        this.postId = postId;
        this.content = content;
        this.commentLike = commentLike;
        this.commentDislike = commentDislike;
        this.commentTime = commentTime;
        this.edited = edited;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(Long commenterId) {
        this.commenterId = commenterId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(int commentLike) {
        this.commentLike = commentLike;
    }

    public int getCommentDislike() {
        return commentDislike;
    }

    public void setCommentDislike(int commentDislike) {
        this.commentDislike = commentDislike;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getEdited() {
        return edited;
    }

    public void setEdited(int edited) {
        this.edited = edited;
    }
}
