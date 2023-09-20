package com.amani.blogsspringboot.services;

import com.amani.blogsspringboot.models.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category findByCategoryId(Long categoryId);

    
}
