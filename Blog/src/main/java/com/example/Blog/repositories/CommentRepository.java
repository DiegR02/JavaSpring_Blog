package com.example.Blog.repositories;

import com.example.Blog.models.Comment;
import com.example.Blog.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public Comment findById(long id);

    public List<Comment> findByEntry(Entry entry);
}
