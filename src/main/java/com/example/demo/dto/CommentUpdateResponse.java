package com.example.demo.dto;

import lombok.Setter;

@Setter
public class CommentUpdateResponse {
    private String text;

    public CommentUpdateResponse(String text) {
        this.text = text;
    }
}
