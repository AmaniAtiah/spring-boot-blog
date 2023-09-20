package com.amani.blogsspringboot.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import com.amani.blogsspringboot.repository.TagRepository;
import com.amani.blogsspringboot.services.CategoryService;
import com.amani.blogsspringboot.services.TagService;


@RestController
@RequestMapping("api/tags")
public class TagController {
    private TagService tagService;
    private TagRepository tagRepository;

    public TagController(TagService tagService, TagRepository tagRepository){
        this.tagService = tagService;
        this.tagRepository = tagRepository;
    }
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag savedtag = tagService.createTag(tag);
        return new ResponseEntity<Tag>(savedtag, HttpStatus.CREATED);

    }

    // @GetMapping("/{tagId}/posts")
    // public ResponseEntity<Tag> getAllPostsByTagId(@PathVariable(value = "tagId") Long tagId) {
     
      
    //   Tag tag = tagService.findByTagsId(tagId);
    //   return new ResponseEntity<>(tag, HttpStatus.OK);
  
  
    // }



    
}
