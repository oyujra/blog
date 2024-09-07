package com.bisa.blog.controller;

import com.bisa.blog.model.Autor;
import com.bisa.blog.service.AutorService;
import com.bisa.blog.exception.BusinessException;
import com.bisa.blog.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<?> crearAutor(@RequestBody Autor autor) {
        try {
            Autor nuevoAutor = autorService.crearAutor(autor);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAutor);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErrorResponse("Business Error", "Error al crear el autor: " + e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al crear el autor: " + e.getMessage())
            );
        }
    }

    @GetMapping
    public ResponseEntity<?> listarAutores() {
        try {
            List<Autor> autores = autorService.listarAutores();
            return ResponseEntity.ok(autores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ErrorResponse("System Error", "Error inesperado al listar autores: " + e.getMessage())
            );
        }
    }
}
