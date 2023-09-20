package com.amani.blogsspringboot.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.amani.blogsspringboot.models.Category;
import com.amani.blogsspringboot.models.Post;
import com.amani.blogsspringboot.models.Tag;
import com.amani.blogsspringboot.repository.CategoryRepository;
import com.amani.blogsspringboot.repository.PostRepository;
import com.amani.blogsspringboot.repository.TagRepository;


@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
        private TagRepository tagRepository;


    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository, TagRepository tagRepository){
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }


    @Override

    public Post createPost(Post post ) {

        Long categoryId = post.getCategory().getId();


        Category category =  categoryRepository.findById(categoryId).get();
         post.setCategory(category);


         Set<Tag> tags = new HashSet<>();
         

        post.getTags().forEach(tag -> {
            Long tagId = tag.getId();
            tags.add(tagRepository.findById(tagId).get());

        });
        
         post.setTags(tags);
        return postRepository.save(post);

    }


    @Override
    public List<Post> findAllPostByTagId(Long tagId) {
        // Optional<Tag> optionalTag = tagRepository.findById(tagId);
        // Tag tag =optionalTag.get();
        
        List<Post> posts = postRepository.findByTagsId(tagId);
                 
         return posts;
    }


    @Override
    public Post getPostById(Long postId) {
        // TODO Auto-generated method stub
        Optional<Post> optionalPost = postRepository.findById(postId);
        return optionalPost.get();
    }


    @Override
    public List<Post> findAllPostByCategoryId(Long categoryId) {
        // TODO Auto-generated method stub
            List<Post> posts = postRepository.findByCategoryId(categoryId);
            return posts;
    }


    @Override
    public List<Post> getAllPost() {
        // TODO Auto-generated method stub
        return postRepository.findAll();
    }


    


//  if (!categoryRepository.existsById(categoryId)) {
//       throw new ResourceNotFoundException("Not found Category with id = " + categoryId);
//     }

//     List<Post> posts = postRepository.findByCategoryId(categoryId);
//     return new ResponseEntity<>(posts, HttpStatus.OK);

 
    
}
