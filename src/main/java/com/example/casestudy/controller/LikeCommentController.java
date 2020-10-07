package com.example.casestudy.controller;

import com.example.casestudy.model.LikeComment;
import com.example.casestudy.service.likecomment.ILikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/like/comment")
public class LikeCommentController {
    @Autowired
    ILikeCommentService likeCommentService;

    @PostMapping("/create")
    public ResponseEntity<LikeComment> createLikeComment(LikeComment likeComment) {
        return new ResponseEntity<>(likeCommentService.saveLikeComment(likeComment), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LikeComment> updateLikeComment(@PathVariable Long id, @RequestBody LikeComment likeComment) {
        likeComment.setId(id);
        return new ResponseEntity<>(likeCommentService.saveLikeComment(likeComment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteLikeComment(@PathVariable Long id) {
        likeCommentService.deleteLikeComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<Iterable<LikeComment>> getAllLikeComment() {
        return new ResponseEntity<>(likeCommentService.findAllLikeComment(),HttpStatus.OK);
    }
}
