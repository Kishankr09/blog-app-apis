package com.kishan.blogappapis.services;

import com.kishan.blogappapis.entities.Post;
import com.kishan.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {

    Post createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<Post> getAllPosts();

    Post getPostById(Integer postId);

    List<Post> getPostsByCategory(Integer categoryId);

    List<Post> getPostsByUser(Integer userId);

    List<Post> searchPosts(String keyword);


}
