package com.example.casestudy.service.user;

import com.example.casestudy.model.User;
import com.example.casestudy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getUserId()).get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByUserEmail(email);
    }

    @Override
    public Iterable<User> findUserByName(String input) {
        return userRepository.findUsersByUserNameContaining(input);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
