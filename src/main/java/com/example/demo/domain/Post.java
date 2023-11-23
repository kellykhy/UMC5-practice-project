package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	public Post(String text, String title, Member member) {
		this.text = text;
		this.title = title;
		this.member = member;
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
