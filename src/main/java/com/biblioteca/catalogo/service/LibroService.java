package com.biblioteca.catalogo.service;

import com.biblioteca.catalogo.dto.LibroDTO;
import com.biblioteca.catalogo.model.Autor;
import com.biblioteca.catalogo.model.Libro;
import com.biblioteca.catalogo.repository.AutorRepository;
import com.biblioteca.catalogo.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
    public void buscarLibroPorTitulo(String titulo) {
        List<Libro> libros = libroRepository.findByTituloContaining(titulo);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros con el título: " + titulo);
        } else {
            libros.forEach(libro -> System.out.println(libro.getTitulo() + " - " + libro.getAutores()));
        }
    }

    public void listarLibros() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
        } else {
            libros.forEach(libro -> System.out.println(libro.getTitulo() + " - " + libro.getAutores()));
        }
    }
}
