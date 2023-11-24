package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// Member의 구성요소 - id, 이름, 닉네임, 나이, 성별
// 각 필드의 타입은 본인이 원하는대로 하면됩니다.
// 여기에 뭐가 들어갈까요?
@Entity
public class Member {

	// 여기에 뭐가 들어갈까요?
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// 나머지 필드를 선언해주세요
	private String name;
	private String gender;

	@OneToMany(mappedBy = "member")
	private List<Post> posts = new ArrayList<>();

	// 생성자와 Getter, Setter 도 필요합니다
	// Setter 는 안쓰는것이 좋지만 예제의 복잡도를 줄이기 위해 그냥 과제에서는 쓰는것으로 합니다.
	public Member(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public Long getId() { return id; }

	public String getName() { return name; }

	public String getGender() { return gender; }

	public void setName(String name) { this.name = name; }

	public void setGender(String gender) { this.gender = gender; }

	/**
	 * 이건 지우지말고 냅두세요
	 */
	protected Member() {
	}
}
