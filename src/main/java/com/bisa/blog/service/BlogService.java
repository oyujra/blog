package com.bisa.blog.service;

import com.bisa.blog.model.Autor;
import com.bisa.blog.model.Blog;
import com.bisa.blog.model.Comentario;
import com.bisa.blog.repository.BlogRepository;
import com.bisa.blog.repository.AutorRepository;
import com.bisa.blog.repository.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

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
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));

        List<Comentario> comentarios = comentarioRepository.findByBlogId(id);
        blog.setComentarios(comentarios);

        if (!comentarios.isEmpty()) {
            OptionalInt minPuntuacion = comentarios.stream()
                    .mapToInt(Comentario::getPuntuacion)
                    .min();
            OptionalInt maxPuntuacion = comentarios.stream()
                    .mapToInt(Comentario::getPuntuacion)
                    .max();
            OptionalDouble avgPuntuacion = comentarios.stream()
                    .mapToInt(Comentario::getPuntuacion)
                    .average();

            blog.setMinPuntuacion(minPuntuacion.orElse(0));
            blog.setMaxPuntuacion(maxPuntuacion.orElse(0));
            blog.setAvgPuntuacion(avgPuntuacion.orElse(0.0));
        } else {
            blog.setMinPuntuacion(0);
            blog.setMaxPuntuacion(0);
            blog.setAvgPuntuacion(0.0);
        }

        return blog;
    }
}