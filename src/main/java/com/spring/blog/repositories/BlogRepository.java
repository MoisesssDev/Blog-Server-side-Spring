package com.spring.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.model.PostModel;

public interface BlogRepository extends JpaRepository<PostModel, Long>{

}
