package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private String title;

	public Post(String title, String text) {
		this.title = title;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	protected Post() {
	}
}
