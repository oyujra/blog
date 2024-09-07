package com.bisa.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String tema;

    @Lob
    private String contenido; // Para almacenar texto extenso o JSON

    @Enumerated(EnumType.STRING)
    private Periodicidad periodicidad;

    private boolean permiteComentarios;

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    @Transient
    private int minPuntuacion;

    @Transient
    private int maxPuntuacion;

    @Transient
    private double avgPuntuacion;
}

