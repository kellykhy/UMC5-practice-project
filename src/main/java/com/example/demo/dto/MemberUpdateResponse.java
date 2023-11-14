package com.example.demo.dto;

public class MemberUpdateResponse {
    private String name;
    private String gender;

    public MemberUpdateResponse(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) { this.name = name; }

    public void setGender(String gender) { this.gender = gender; }
}
