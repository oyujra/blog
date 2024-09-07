package com.bisa.blog.service;

import com.bisa.blog.model.Autor;
import com.bisa.blog.model.Blog;
import com.bisa.blog.repository.BlogRepository;
import com.bisa.blog.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AutorRepository autorRepository;

    public Blog crearBlog(Blog blog) {
        // Verificar si el autor existe
        Autor autor = autorRepository.findById(blog.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        blog.setAutor(autor);  // Asegurar la referencia del autor
        return blogRepository.save(blog);
    }

    public Blog actualizarBlog(Long id, Blog blogActualizado) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));
        blog.setTitulo(blogActualizado.getTitulo());
        blog.setContenido(blogActualizado.getContenido());
        blog.setTema(blogActualizado.getTema());
        blog.setPermiteComentarios(blogActualizado.isPermiteComentarios());
        return blogRepository.save(blog);
    }

    public List<Blog> listarBlogs() {
        return blogRepository.findAll();
    }

    public Blog obtenerBlogPorId(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));
    }
}