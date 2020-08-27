package com.example.casestudy.repository;

import com.example.casestudy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findByPosterId(Long userId);
}
