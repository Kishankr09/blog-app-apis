package com.kishan.blogappapis.reposirories;


import com.kishan.blogappapis.entities.Category;
import com.kishan.blogappapis.entities.Post;
import com.kishan.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
