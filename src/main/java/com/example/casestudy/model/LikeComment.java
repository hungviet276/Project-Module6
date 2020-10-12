package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "likecomment")
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long commentId;

    private Long likerId;

    public LikeComment() {
    }

    public LikeComment(Long id, Long commentId, Long likerId) {
        this.id = id;
        this.commentId = commentId;
        this.likerId = likerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commenterId) {
        this.commentId = commenterId;
    }

    public Long getLikerId() {
        return likerId;
    }

    public void setLikerId(Long likerId) {
        this.likerId = likerId;
    }
}
