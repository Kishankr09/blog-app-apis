package com.kishan.blogappapis.services;

import com.kishan.blogappapis.entities.Category;
import com.kishan.blogappapis.payloads.CategoryDto;
import java.util.List;

public interface CategoryService {

    //Create
     CategoryDto createCategory(CategoryDto categoryDto);

    //update
     CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get
     CategoryDto getCategory(Integer categoryId);

    //get All
     List<CategoryDto> getCategories();

}
