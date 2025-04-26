package com.kishan.blogappapis.services.impl;

import com.kishan.blogappapis.entities.Category;
import com.kishan.blogappapis.entities.Post;
import com.kishan.blogappapis.entities.User;
import com.kishan.blogappapis.exceptions.ResourceNotFoundException;
import com.kishan.blogappapis.payloads.PostDto;
import com.kishan.blogappapis.reposirories.CategoryRepo;
import com.kishan.blogappapis.reposirories.PostRepo;
import com.kishan.blogappapis.reposirories.UserRepo;
import com.kishan.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Post createPost(PostDto postDto,Integer userId, Integer categoryId ) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));

        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));


        Post post = modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost =  this.postRepo.save(post);
        return this.modelMapper.map(newPost, Post.class);
    }


    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPosts() {
        return List.of();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}
