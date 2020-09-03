package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "Like-Comment")
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long commenterId;

    private Long likerId;

    public LikeComment() {
    }

    public LikeComment(Long id, Long commenterId, Long likerId) {
        this.id = id;
        this.commenterId = commenterId;
        this.likerId = likerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(Long commenterId) {
        this.commenterId = commenterId;
    }

    public Long getLikerId() {
        return likerId;
    }

    public void setLikerId(Long likerId) {
        this.likerId = likerId;
    }
}
