package com.example.casestudy.service;

import com.example.casestudy.model.User;

public interface IUserService {
    User saveUser(User user);

    void deleteUser(Long id);

    Iterable<User> findAllUser();

    User findUserById(Long id);

    User findUserByEmail(String email);

    Iterable<User> findUserByName(String input);
}
