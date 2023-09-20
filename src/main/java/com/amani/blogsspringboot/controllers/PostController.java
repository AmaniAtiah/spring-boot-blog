package com.amani.blogsspringboot.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amani.blogsspringboot.exception.ResourceNotFoundException;
import com.amani.blogsspringboot.models.Category;
import com.amani.blogsspringboot.models.Post;
import com.amani.blogsspringboot.models.Tag;
import com.amani.blogsspringboot.repository.CategoryRepository;
import com.amani.blogsspringboot.repository.PostRepository;
import com.amani.blogsspringboot.services.CategoryService;
import com.amani.blogsspringboot.services.PostService;


@RestController
@RequestMapping("api")

public class PostController {
    private PostService postService;
    private CategoryRepository categoryRepository;
    private PostRepository postRepository;
        private CategoryService categoryService;


    public PostController(PostService postService, CategoryRepository categoryRepository, PostRepository postRepository, CategoryService categoryService){
        this.postService = postService;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.postRepository = postRepository;
    }
    // @PostMapping("/categories/{categoryId}/posts")
    // public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable(value = "categoryId") Long categoryId) {
    //     categoryRepository.findById(categoryId).map(category -> {
    //         post.setCategory(category);
    //     });
    //     Post savedPost = postService.createPost(post);
    //     return new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);

    // }


    @PostMapping("/posts")

    public ResponseEntity<Post> createPost(
        @RequestBody Post post) {

    //     Long categoryId = post.getCategory().getId();


    //    Category category =  categoryRepository.findById(categoryId).get();


    //  post.setCategory(category);

    Post savedPost = postService.createPost(post);

    return new ResponseEntity<>(savedPost, HttpStatus.CREATED);

        }

        

//     @GetMapping("/tags/{tagId}/posts")
//   public ResponseEntity<List<Post>> getAllPostsByTagId(@PathVariable(value = "tagId") Long tagId) {
//     // if (!categoryRepository.existsById(categoryId)) {
//     //   throw new ResourceNotFoundException("Not found Category with id = " + categoryId);
//     // }
    
//     List<Post> posts = postService.findByTagId(tagId);
//     return new ResponseEntity<>(posts, HttpStatus.OK);


//     // List<Post> posts = postService.findByCategoryId(categoryId);
//   }



@GetMapping("/posts")
public ResponseEntity<List<Post>> findAllPosts() {
 

  List<Post> posts = postService.getAllPost();
  return new ResponseEntity<>(posts, HttpStatus.OK);
}

@GetMapping("/tags/{tagId}/posts")
public ResponseEntity<List<Post>> findAllPostByTagId(@PathVariable(value = "tagId") Long tagId) {
 

  List<Post> posts = postService.findAllPostByTagId(tagId);
  return new ResponseEntity<>(posts, HttpStatus.OK);
}

@GetMapping("/categories/{categoryId}/posts")
public ResponseEntity<List<Post>> findAllPostByCategoryId(@PathVariable(value = "categoryId") Long categroyId) {
 

  List<Post> posts = postService.findAllPostByCategoryId(categroyId);
  return new ResponseEntity<>(posts, HttpStatus.OK);
}

@GetMapping("/posts/{id}")
public ResponseEntity<Post> getPostById(@PathVariable("id") Long postId){
    Post post = postService.getPostById(postId);
    return new ResponseEntity<>(post, HttpStatus.OK);
}

// @GetMapping("/posts/{id}")
// public ResponseEntity<Post> getPostsById(@PathVariable("id") Long id) {
//   Post post = postRepository.findById(id)
//       .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

//   return new ResponseEntity<>(post, HttpStatus.OK);
// }
}