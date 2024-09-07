package com.bisa.blog.controller;

import com.bisa.blog.model.Comentario;
import com.bisa.blog.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs/{blogId}/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public Comentario agregarComentario(@PathVariable Long blogId, @RequestBody Comentario comentario) {
        return comentarioService.agregarComentario(blogId, comentario);
    }
}