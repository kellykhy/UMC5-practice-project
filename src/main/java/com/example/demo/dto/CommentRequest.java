package com.example.demo.dto;

import lombok.Getter;

@Getter
public class CommentRequest {
    private Long post_id;
    private Long member_id;
    private String text;
}
