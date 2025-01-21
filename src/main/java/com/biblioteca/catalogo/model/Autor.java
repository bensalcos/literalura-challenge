package com.biblioteca.catalogo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer anioNacimiento;
    private Integer anioFallecimiento;

    public Autor() {
    }
}
