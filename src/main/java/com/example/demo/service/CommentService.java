package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Member;
import com.example.demo.domain.Post;
import com.example.demo.dto.CommentRequest;
import com.example.demo.dto.CommentUpdateRequest;
import com.example.demo.dto.CommentUpdateResponse;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Long writeComment(CommentRequest request){
        Member member = memberRepository.findById(request.getMember_id()).get();
        Post post = postRepository.findById(request.getPost_id()).get();
        Comment comment = new Comment(request.getText(), member, post);
        Comment savedComment = commentRepository.save(comment);
        return savedComment.getId();
    }

    @Transactional
    public Long deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
        return commentId;
    }

    public CommentUpdateResponse editComment(CommentUpdateRequest request){
        Comment comment = commentRepository.findById(request.getId()).get();
        comment.setText(request.getText());
        return new CommentUpdateResponse(comment.getText());
    }

}
