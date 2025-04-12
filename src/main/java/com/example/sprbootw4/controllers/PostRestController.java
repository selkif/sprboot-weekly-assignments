package com.example.sprbootw4.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/post")
public class PostRestController {

    private int idCounter = 0;
    private final List<Map<String, Object>> posts = new ArrayList<>();

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam String title,
                                      @RequestParam String content,
                                      @RequestParam String author) {
        System.out.println("Post Created");

        Map<String, Object> post = new HashMap<>();
        post.put("id", ++idCounter);
        post.put("title", title);
        post.put("content", content);
        post.put("author", author);
        posts.add(post);

        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", 200);
        response.put("message", "Post created successfully");
        return response;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return posts;
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String id) {
        return posts.stream()
                .filter(post -> String.valueOf(post.get("id")).equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam String id,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) String content,
                                      @RequestParam(required = false) String author) {

        Map<String, Object> post = detail(id);
        if (post != null) {
            if (title != null && !title.isEmpty()) post.put("title", title);
            if (content != null && !content.isEmpty()) post.put("content", content);
            if (author != null && !author.isEmpty()) post.put("author", author);

            Map<String, Object> response = new HashMap<>();
            response.put("resultCode", 200);
            response.put("message", "Post updated successfully");
            return response;
        }

        Map<String, Object> error = new HashMap<>();
        error.put("resultCode", 404);
        error.put("message", "Post not found");
        return error;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam String id) {
        Map<String, Object> post = detail(id);
        if (post != null) {
            posts.remove(post);
            Map<String, Object> response = new HashMap<>();
            response.put("resultCode", 200);
            response.put("message", "Post deleted successfully");
            return response;
        }

        Map<String, Object> error = new HashMap<>();
        error.put("resultCode", 404);
        error.put("message", "Post not found");
        return error;
    }
}
