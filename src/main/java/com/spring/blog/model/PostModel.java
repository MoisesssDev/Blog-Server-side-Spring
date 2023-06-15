package com.spring.blog.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_post")
public class PostModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "(*) O título é obrigatório")
	private String title;
	
	@NotEmpty(message = "(*) O autor é obrigatório")
	private String author;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate date;
	
	@NotEmpty(message = "(*) O texto é obrigatório")
	@Lob
	private String text;
	
	public PostModel() {
	}
	
	
	
	public PostModel(@NotBlank(message = "O título é obrigatório") String title,
			@NotBlank(message = "O autor é obrigatório") String author, LocalDate date,
			@NotBlank(message = "O texto é obrigatório") String text) {
		super();
		this.title = title;
		this.author = author;
		this.date = date;
		this.text = text;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
