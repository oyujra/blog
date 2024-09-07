package com.bisa.blog.controller;

import com.bisa.blog.model.Blog;
import com.bisa.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Blog crearBlog(@RequestBody Blog blog) {
        return blogService.crearBlog(blog);
    }

    @PutMapping("/{id}")
    public Blog actualizarBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.actualizarBlog(id, blog);
    }

    @GetMapping
    public List<Blog> listarBlogs() {
        return blogService.listarBlogs();
    }

    @GetMapping("/{id}")
    public Blog obtenerBlogPorId(@PathVariable Long id) {
        return blogService.obtenerBlogPorId(id);
    }
}
