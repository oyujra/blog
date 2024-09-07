package com.bisa.blog.service;

import com.bisa.blog.model.Autor;
import com.bisa.blog.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }
}
