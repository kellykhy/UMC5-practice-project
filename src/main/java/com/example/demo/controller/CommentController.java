package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.dto.CommentRequest;
import com.example.demo.dto.CommentUpdateRequest;
import com.example.demo.dto.CommentUpdateResponse;
import com.example.demo.dto.PostRequest;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public Long post(@RequestBody CommentRequest request){
        return commentService.writeComment(request);
    }

    @DeleteMapping("/comments")
    public Long delete(@RequestBody Long commentId){
        return commentService.deleteComment(commentId);
    }

    @PatchMapping("comments")
    public CommentUpdateResponse edit(@RequestBody CommentUpdateRequest request){
        return commentService.editComment(request);
    }


}
