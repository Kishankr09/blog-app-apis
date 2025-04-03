package com.kishan.blogappapis.reposirories;

import com.kishan.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
