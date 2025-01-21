package com.biblioteca.catalogo.service;

import com.biblioteca.catalogo.model.Autor;
import com.biblioteca.catalogo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            autores.forEach(autor -> System.out.println(autor.getNombre() + " - " + autor.getAnioNacimiento()));
        }
    }

    public void listarAutoresVivosEnAnio(int anio) {
        LocalDate fecha = LocalDate.of(anio, 1, 1);
        List<Autor> autores = autorRepository.findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqual(anio, anio);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año: " + anio);
        } else {
            autores.forEach(autor -> System.out.println(autor.getNombre() + " - " + autor.getAnioNacimiento()));
        }
    }
}
