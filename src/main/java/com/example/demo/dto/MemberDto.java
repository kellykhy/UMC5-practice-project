package com.example.demo.dto;

public class MemberDto {
    private Long id;
    private String name;
    private String gender;

    public MemberDto(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Long getId() { return id; }

    public String getGender() { return gender; }

    public String getName() {
        return name;
    }
}
