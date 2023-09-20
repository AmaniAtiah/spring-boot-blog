package com.amani.blogsspringboot.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amani.blogsspringboot.models.Category;
import com.amani.blogsspringboot.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);

    }
    @Override
    public Category findByCategoryId(Long categoryId) {
        // TODO Auto-generated method stub
      Optional<Category> category = categoryRepository.findById(categoryId);
        return category.get();     
      }
    
}
