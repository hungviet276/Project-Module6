package com.example.casestudy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "userNickName"),
                @UniqueConstraint(columnNames = "userEmail")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userEmail;

    private String userPassword;

    private String userName;

    private String account;

    private String userSex;

    private String userAddress;

    private String userAvatar;

    private String userCoverPhoto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String userName, String userSex, String account, String email, String password) {
        this.account = account;
        this.userEmail = email;
        this.userPassword = password;
        this.userName = userName;
        this.userSex = userSex;
    }

    public User(Long userId, String userEmail, String userPassword, String userName, String account, String userSex, String userAddress, String userAvatar, String userCoverPhoto) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.account = account;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String userNickName) {
        this.account = userNickName;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
