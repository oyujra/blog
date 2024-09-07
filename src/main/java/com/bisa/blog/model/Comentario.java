package com.bisa.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePublicador;
    private String correo;
    private String paisResidencia;

    @Lob
    private String comentario;

    private int puntuacion; // Rango de 0 a 10

    @ManyToOne
    @JsonBackReference

    private Blog blog;
}
