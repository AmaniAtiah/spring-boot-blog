package com.amani.blogsspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amani.blogsspringboot.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
     List<Post> findByCategoryId(Long categoryId);
    List<Post> findByTagsId(Long tagId);


    
}
