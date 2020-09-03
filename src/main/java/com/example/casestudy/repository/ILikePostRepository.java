package com.example.casestudy.repository;

import com.example.casestudy.model.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikePostRepository extends JpaRepository<LikePost,Long> {
}
