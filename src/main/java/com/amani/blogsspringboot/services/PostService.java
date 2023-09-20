package com.amani.blogsspringboot.services;

import java.util.List;

import com.amani.blogsspringboot.models.Category;
import com.amani.blogsspringboot.models.Post;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPost();
    Post getPostById(Long psotId);
    List<Post> findAllPostByCategoryId(Long categoryId);
    List<Post> findAllPostByTagId(Long tagId);

    
}
