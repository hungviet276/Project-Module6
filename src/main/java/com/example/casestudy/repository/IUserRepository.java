package com.example.casestudy.repository;

import com.example.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUserEmail(String email);

    Iterable<User> findUsersByUserNameContaining(String input);
}
