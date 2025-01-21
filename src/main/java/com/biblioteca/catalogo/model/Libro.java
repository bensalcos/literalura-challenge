package com.biblioteca.catalogo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    // Relación many-to-many con los autores
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "libro_autores", // Tabla intermedia para la relación many-to-many
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    // Almacenamos idiomas en una tabla secundaria usando ElementCollection
    @ElementCollection
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<String> idiomas;

    private int numeroDescargas;
}
