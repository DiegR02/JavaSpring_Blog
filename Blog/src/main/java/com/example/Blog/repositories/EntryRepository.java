package com.example.Blog.repositories;

import com.example.Blog.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    public Entry findById(long id);
    public List<Entry> findAll();

}
