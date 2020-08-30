package com.example.casestudy.controller;

import com.example.casestudy.model.Post;
import com.example.casestudy.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setPostTime(timeConvert());
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setPostId(id);
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Post>> findAllPost() {
        return new ResponseEntity<>(postService.findAllPost(), HttpStatus.OK);
    }

    @GetMapping("findPostById/{postId}")
    public ResponseEntity<Post> findPostById(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.findPostByPostId(postId), HttpStatus.OK);
    }

    @GetMapping("findPostByPosterId/{posterId}")
    public ResponseEntity<Iterable<Post>> findPostByPosterId(@PathVariable Long posterId) {
        return new ResponseEntity<>(postService.findPostByPosterId(posterId), HttpStatus.OK);
    }

    private String timeConvert() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return myDateObj.format(myFormatObj);
    }
}
