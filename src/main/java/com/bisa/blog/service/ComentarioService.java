package com.bisa.blog.service;

import com.bisa.blog.model.Blog;
import com.bisa.blog.model.Comentario;
import com.bisa.blog.repository.BlogRepository;
import com.bisa.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private BlogRepository blogRepository;

    public Comentario agregarComentario(Long blogId, Comentario comentario) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));

        if (!blog.isPermiteComentarios()) {
            throw new RuntimeException("Este blog no permite comentarios");
        }

        comentario.setBlog(blog);
        return comentarioRepository.save(comentario);
    }
}
