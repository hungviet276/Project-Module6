package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userEmail;

    private String userPassword;

    private String userName;

    private String userNickName;

    private String userSex;

    private String userAddress;

    private String userAvatar;

    private String userCoverPhoto;

    public User() {
    }

    public User(Long userId, String userEmail, String userPassword, String userName, String userNickName, String userSex, String userAddress, String userAvatar, String userCoverPhoto) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickName = userNickName;
        this.userSex = userSex;
        this.userAddress = userAddress;
        this.userAvatar = userAvatar;
        this.userCoverPhoto = userCoverPhoto;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String sex) {
        this.userSex = sex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String address) {
        this.userAddress = address;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String avatar) {
        this.userAvatar = avatar;
    }

    public String getUserCoverPhoto() {
        return userCoverPhoto;
    }

    public void setUserCoverPhoto(String coverPhoto) {
        this.userCoverPhoto = coverPhoto;
    }
}
