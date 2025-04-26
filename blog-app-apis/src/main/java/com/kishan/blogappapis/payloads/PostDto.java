package com.kishan.blogappapis.payloads;

import com.kishan.blogappapis.entities.Category;
import com.kishan.blogappapis.entities.User;

import java.util.Date;

public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private Category category;
    private User user;

}
