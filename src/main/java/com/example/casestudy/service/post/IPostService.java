package com.example.casestudy.service.post;

import com.example.casestudy.model.Post;

public interface IPostService {
    Post savePost(Post post);

    void deletePost(Long id);

    Iterable<Post> findAllPost();

    Post findPostByPostId(Long id);

    Iterable<Post> findPostByPosterId(Long userId);

    Iterable<Post> findByPosterIdAndTextPostContains(Long id,String textPost);
}
