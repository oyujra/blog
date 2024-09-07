package com.bisa.blog.controller;

import com.bisa.blog.model.Autor;
import com.bisa.blog.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.crearAutor(autor);
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }
}
