package com.example.casestudy.controller;

import com.example.casestudy.model.Comment;
import com.example.casestudy.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setCommentId(id);
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Comment>> findAllComment() {
        return new ResponseEntity<>(commentService.findAllComment(), HttpStatus.OK);
    }

    @GetMapping("findCommentById/{commentId}")
    public ResponseEntity<Comment> findCommentById(@PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.findCommentByCommentId(commentId), HttpStatus.OK);
    }

    @GetMapping("findCommentsByPostId/{postId}")
    public ResponseEntity<Iterable<Comment>> findCommentsByPostId(@PathVariable Long postId) {
        return new ResponseEntity<>(commentService.findCommentsByPostId(postId), HttpStatus.OK);
    }

    @GetMapping("findCommentsByCommenterId/{commenterId}")
    public ResponseEntity<Iterable<Comment>> findCommentsByCommenterId(@PathVariable Long commenterId) {
        return new ResponseEntity<>(commentService.findCommentByCommenterId(commenterId), HttpStatus.OK);
    }
}
