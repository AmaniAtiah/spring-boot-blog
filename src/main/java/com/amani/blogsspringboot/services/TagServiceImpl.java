package com.amani.blogsspringboot.services;

import java.util.Optional;
 import java.util.List;

import org.springframework.stereotype.Service;

import com.amani.blogsspringboot.models.Category;
import com.amani.blogsspringboot.models.Post;
import com.amani.blogsspringboot.models.Tag;
import com.amani.blogsspringboot.repository.CategoryRepository;
import com.amani.blogsspringboot.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService{

    private TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }
    @Override
    public Tag createTag(Tag tag) {

        return tagRepository.save(tag);

    }

    // @Override
    // public Tag findByTagsId(Long tagId) {
    //     // TODO Auto-generated method stub
    //     Optional<Tag> tags = tagRepository.findById(tagId);
    //     return tags.get();  
    //    }
           

  
    
}
