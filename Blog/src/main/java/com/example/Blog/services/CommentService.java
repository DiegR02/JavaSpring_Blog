package com.example.Blog.services;

import com.example.Blog.models.Comment;
import com.example.Blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(long id){
        return commentRepository.findById(id);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }
}
