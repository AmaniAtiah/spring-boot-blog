package com.amani.blogsspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amani.blogsspringboot.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
