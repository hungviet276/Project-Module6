package com.example.casestudy.controller;

import com.example.casestudy.model.Post;
import com.example.casestudy.service.post.IPostService;
import javafx.geometry.Pos;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Post> findPostById(@SortDefault(direction = Sort.Direction.DESC,sort = "postId") @PathVariable Long postId) {
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

    @GetMapping("/searchPost/{posterId}/{textPost}")
    public ResponseEntity<Iterable<Post>> searchPostByTextPost(@PathVariable Long posterId, @PathVariable String textPost) {
        return new ResponseEntity<>(postService.findByPosterIdAndTextPostContains(posterId,textPost), HttpStatus.OK);
    }

    @GetMapping("findImageByPosterId/{posterId}")
    public ResponseEntity<Iterable<String>> findImageByPosterId(@PathVariable Long posterId) {
        List<String> images = new ArrayList<>();
        Iterable<Post> posts = postService.findPostByPosterId(posterId);
        for (Post post: posts) {
            if (!post.getImagePost().isEmpty() && post.getImagePost() != null) {
                images.add(post.getImagePost());
            }
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/getPostLimited/{fromIndex}")
    public ResponseEntity<Iterable<Post>> findPostLimited(@PathVariable int fromIndex) {
        Iterable<Post> allPost = postService.findAllPost();
        List<Post> postList = new ArrayList<>();
        allPost.forEach(postList::add);
        List<Post> limitedPost = new ArrayList<>();
        for (int i = fromIndex; i < fromIndex + 5 && i < postList.size() ; i++) {
            limitedPost.add(postList.get(i));
        }
        return new ResponseEntity<>( limitedPost, HttpStatus.OK);
    }


    @GetMapping("findImageByPosterIdLimited/{posterId}/{fromIndex}")
    public ResponseEntity<Iterable<Post>> findPostByPosterId(@PathVariable Long posterId, @PathVariable int fromIndex) {
        Iterable<Post> allPost = postService.findPostByPosterId(posterId);
        List<Post> postList = new ArrayList<>();
        allPost.forEach(postList::add);
        List<Post> limitedPost = new ArrayList<>();
        for (int i = fromIndex; i < fromIndex + 5 && i < postList.size() ; i++) {
            limitedPost.add(postList.get(i));
        }
        return new ResponseEntity<>(limitedPost, HttpStatus.OK);
    }
}
