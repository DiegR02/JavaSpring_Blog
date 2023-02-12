package com.example.Blog.controllers;

import com.example.Blog.models.Comment;
import com.example.Blog.models.Entry;
import org.springframework.ui.Model;
import com.example.Blog.services.CommentService;
import com.example.Blog.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Controller
public class Main {
    @Autowired
    EntryService entryService;
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String principal(Model model){
        model.addAttribute("entryList", entryService.findAll());
        return "index";
    }

    //Show image
    @GetMapping("/img/{imageName}")
    // 'imageName' -> name of the image.
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            //Path object
            Path path = Paths.get("src/main/resources/static/img/" + imageName);

            //Read and save
            byte[] image = Files.readAllBytes(path);

            // HTTP answer -> "MediaType.IMAGE_JPEG"
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Show specific entry
    @GetMapping("/entry/{id}")
    public String showEntry(@PathVariable Long id, Model model) {
        Entry entry = entryService.findById(id);
        model.addAttribute("entry", entry);
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.findAll());
        return "entry";

    }


    @PostMapping("/entry/{id}")
    public String addComment(@PathVariable Long id, @ModelAttribute Comment comment) {
        Entry entry = entryService.findById(id);
        comment.setEntry(entry);
        commentService.save(comment);
        return "redirect:/entry/{id}";
    }

}