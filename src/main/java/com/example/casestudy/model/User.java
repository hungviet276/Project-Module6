package com.example.casestudy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "userName"),
                @UniqueConstraint(columnNames = "userEmail")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userSex;

    private String dateOfBirth;

    private String about;

    private String userAddress;

    private String userPhoneNumber;

    private String userAvatar;

    private String userCoverPhoto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String userName, String userSex, String email, String password) {
        this.userName = userName;
        this.userEmail = email;
        this.userPassword = password;
        this.userSex = userSex;
    }

    public User(Long userId, String userName, String userEmail, String userPassword, String userSex, String dateOfBirth, String about, String userAddress, String userPhoneNumber, String userAvatar, String userCoverPhoto, Set<Role> roles) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.dateOfBirth = dateOfBirth;
        this.about = about;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userAvatar = userAvatar;
        this.userCoverPhoto = userCoverPhoto;
        this.roles = roles;
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String sex) {
        this.userSex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String address) {
        this.userAddress = address;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
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
