package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private Long posterId;

    private String textPost;

    private String imagePost;

    private String videoPost;

    private String linkPost;

    private String postTime;

    private Long status;

    private int postLike;

    private int postDislike;

    public Post() {
    }

    public Post(Long postId, Long posterId, String textPost, int postLike, int postDislike, Long status){
        this.postId = postId;
        this.posterId = posterId;
        this.textPost = textPost;
        this.postLike = postLike;
        this.postDislike = postDislike;
        this.status = status;
    }

    public Post(Long postId, Long posterId, String textPost, String imagePost, String videoPost, String linkPost, String postTime, int postLike, int postDislike,Long status) {
        this.postId = postId;
        this.posterId = posterId;
        this.textPost = textPost;
        this.imagePost = imagePost;
        this.videoPost = videoPost;
        this.linkPost = linkPost;
        this.postTime = postTime;
        this.postLike = postLike;
        this.postDislike = postDislike;
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPosterId() {
        return posterId;
    }

    public void setPosterId(Long postUserId) {
        this.posterId = postUserId;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    public String getImagePost() {
        return imagePost;
    }

    public void setImagePost(String imagePost) {
        this.imagePost = imagePost;
    }

    public String getVideoPost() {
        return videoPost;
    }

    public void setVideoPost(String videoPost) {
        this.videoPost = videoPost;
    }

    public String getLinkPost() {
        return linkPost;
    }

    public void setLinkPost(String linkPost) {
        this.linkPost = linkPost;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postDate) {
        this.postTime = postDate;
    }

    public int getPostLike() {
        return postLike;
    }

    public void setPostLike(int postLike) {
        this.postLike = postLike;
    }

    public int getPostDislike() {
        return postDislike;
    }

    public void setPostDislike(int postDislike) {
        this.postDislike = postDislike;
    }
}
