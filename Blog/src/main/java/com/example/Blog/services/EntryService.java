package com.example.Blog.services;

import com.example.Blog.models.Entry;
import com.example.Blog.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    @Autowired
    EntryRepository entryRepository;

    public List<Entry> findAll(){
        return entryRepository.findAll();
    }

    public Entry findById(long id){
        return entryRepository.findById(id);
    }

    public Entry save(Entry entry){
        return entryRepository.save(entry);
    }

    public void delete(Entry entry){
        entryRepository.delete(entry);
    }

}
