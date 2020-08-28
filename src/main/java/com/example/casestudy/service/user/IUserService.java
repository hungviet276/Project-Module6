package com.example.casestudy.service.user;

import com.example.casestudy.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    void deleteUser(Long id);

    Iterable<User> findAllUser();

    User findUserById(Long id);

    User findUserByEmail(String email);

    Iterable<User> findUserByName(String input);

    Optional<User> findByUserName(String userName);
}
