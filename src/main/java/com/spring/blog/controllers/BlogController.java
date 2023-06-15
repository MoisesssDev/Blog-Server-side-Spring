package com.spring.blog.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.model.PostModel;
import com.spring.blog.services.BlogService;

import jakarta.validation.Valid;

@RestController
public class BlogController {

	@Autowired
	BlogService blogService;

	@GetMapping("/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<PostModel> posts = blogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	@GetMapping("posts/{id}")
	public ModelAndView getPostDetails(@PathVariable(value = "id") Long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		PostModel post = blogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}

	@GetMapping("/newpost")
	public ModelAndView getPostForm(Model model) {
		model.addAttribute("postModel", new PostModel());

		ModelAndView mv = new ModelAndView("postForm");
		return mv;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		blogService.delete(id);

		return "redirect:/posts";
	}

	@PostMapping("/newpost")
	public ModelAndView savePost(@Valid @ModelAttribute("postModel") PostModel post, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("postForm");
			return mv;
		}

		post.setDate(LocalDate.now());
		blogService.save(post);

		return getPosts();
	}

}
