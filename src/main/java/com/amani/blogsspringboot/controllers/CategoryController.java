package com.amani.blogsspringboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amani.blogsspringboot.models.Category;
import com.amani.blogsspringboot.services.CategoryService;


@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedcategory = categoryService.createCategory(category);
        return new ResponseEntity<Category>(savedcategory, HttpStatus.CREATED);

    }

  //   @GetMapping("/{categoryId}/posts")
  // public ResponseEntity<Category> getAllPostsByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {
  //   // if (!categoryRepository.existsById(categoryId)) {
  //   //   throw new ResourceNotFoundException("Not found Category with id = " + categoryId);
  //   // }
    
  //   Category category = categoryService.findByCategoryId(categoryId);
  //   return new ResponseEntity<>(category, HttpStatus.OK);


  //   // List<Post> posts = postService.findByCategoryId(categoryId);
  // }

    
}
