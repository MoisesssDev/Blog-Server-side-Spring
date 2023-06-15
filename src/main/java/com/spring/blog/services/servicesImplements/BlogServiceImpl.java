package com.spring.blog.services.servicesImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.model.PostModel;
import com.spring.blog.repositories.BlogRepository;
import com.spring.blog.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogRepository blogRepository;

	@Override
	public List<PostModel> findAll() {
		return blogRepository.findAll();
	}

	@Override
	public PostModel findById(Long id) {
		return blogRepository.findById(id).get();
	}

	@Override
	public PostModel save(PostModel post) {
		return blogRepository.save(post);
	}

	@Override
	public void delete(Long Id) {
		blogRepository.deleteById(Id);
	}

}
