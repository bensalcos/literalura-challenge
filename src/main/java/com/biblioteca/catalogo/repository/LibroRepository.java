package com.biblioteca.catalogo.repository;

import com.biblioteca.catalogo.dto.LibroDTO;
import com.biblioteca.catalogo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTituloContaining(String titulo);
}
