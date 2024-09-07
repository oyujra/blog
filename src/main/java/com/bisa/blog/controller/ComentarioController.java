package com.bisa.blog.controller;

import com.bisa.blog.model.Comentario;
import com.bisa.blog.service.ComentarioService;
import com.bisa.blog.exception.BusinessException;
import com.bisa.blog.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs/{blogId}/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<?> agregarComentario(@PathVariable Long blogId, @RequestBody Comentario comentario) {
        try {
            Comentario nuevoComentario = comentarioService.agregarComentario(blogId, comentario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComentario);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErrorResponse("Business Error", "Error al agregar el comentario: " + e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al agregar el comentario: " + e.getMessage())
            );
        }
    }
}