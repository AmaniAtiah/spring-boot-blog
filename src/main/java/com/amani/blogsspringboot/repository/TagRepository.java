package com.amani.blogsspringboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amani.blogsspringboot.models.Post;
import com.amani.blogsspringboot.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
//        List<Post> findByTagId(Long tagId);

}
