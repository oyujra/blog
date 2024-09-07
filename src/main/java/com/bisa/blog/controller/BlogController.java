package com.bisa.blog.controller;

import com.bisa.blog.model.Blog;
import com.bisa.blog.service.BlogService;
import com.bisa.blog.exception.BusinessException;
import com.bisa.blog.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<?> crearBlog(@RequestBody Blog blog) {
        try {
            Blog nuevoBlog = blogService.crearBlog(blog);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoBlog);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErrorResponse("Business Error", "Error al crear el blog: " + e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al crear el blog: " + e.getMessage())
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarBlog(@PathVariable Long id, @RequestBody Blog blog) {
        try {
            Blog blogActualizado = blogService.actualizarBlog(id, blog);
            return ResponseEntity.ok(blogActualizado);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErrorResponse("Business Error", "Error al actualizar el blog: " + e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al actualizar el blog: " + e.getMessage())
            );
        }
    }

    @GetMapping
    public ResponseEntity<?> listarBlogs() {
        try {
            List<Blog> blogs = blogService.listarBlogs();
            return ResponseEntity.ok(blogs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al listar blogs: " + e.getMessage())
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerBlogPorId(@PathVariable Long id) {
        try {
            Blog blog = blogService.obtenerBlogPorId(id);
            return ResponseEntity.ok(blog);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ErrorResponse("Business Error", "Blog no encontrado: " + e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al obtener el blog: " + e.getMessage())
            );
        }
    }
}
