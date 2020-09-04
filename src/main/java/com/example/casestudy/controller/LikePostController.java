package com.example.casestudy.controller;

import com.example.casestudy.model.LikePost;
import com.example.casestudy.service.likepost.ILikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/like/post")
public class LikePostController {
    @Autowired
    ILikePostService likePostService;

    @PostMapping("/create")
    public ResponseEntity<LikePost> createLikePost(@RequestBody LikePost likePost) {
        return new ResponseEntity<>(likePostService.saveLikePost(likePost), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LikePost> updateLikePost(@PathVariable Long id, @RequestBody LikePost likePost) {
        likePost.setId(id);
        return new ResponseEntity<>(likePostService.saveLikePost(likePost), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteLikePost(@PathVariable Long id) {
        likePostService.deleteLikePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<LikePost>> getAllLikePost() {
        return new ResponseEntity<>(likePostService.findAllLikePost(),HttpStatus.OK);
    }

    @GetMapping("/findByPostId/{postId}")
    public ResponseEntity<Iterable<LikePost>> findLikePostByPostId(@PathVariable Long postId) {
        return new ResponseEntity<>(likePostService.findLikePostByPostId(postId),HttpStatus.OK);
    }
}
