package com.biblioteca.catalogo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDTO {
    @JsonAlias("title")
    private String titulo;

    @JsonAlias("authors")
    private List<AutorDTO> autores;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("download_count")
    private Integer numeroDescargas;

    @Override
    public String toString() {
        String autoresNombres = autores.stream()
                .map(autor -> {
                    String nombreCompleto = autor.getNombre();
                    if (nombreCompleto.contains(",")) {
                        // Divide el nombre en partes y reordénalo
                        String[] partes = nombreCompleto.split(", ");
                        return partes[1] + " " + partes[0];
                    }
                    return nombreCompleto; // Devuelve el nombre sin cambios si no contiene coma
                })
                .reduce((a, b) -> a + ", " + b)
                .orElse("Sin autores");

        return "Título: " + titulo + "\n" +
                "Autores: " + autoresNombres + "\n" +
                "Idiomas: " + String.join(", ", idiomas) + "\n" +
                "Número de descargas: " + numeroDescargas + "\n";
    }



}
