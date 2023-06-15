package com.spring.blog.services;

import java.util.List;

import com.spring.blog.model.PostModel;

public interface BlogService{
	
	List<PostModel> findAll();
	
	PostModel findById(Long id);
	
	PostModel save(PostModel post);

	void delete(Long id);
	
}
