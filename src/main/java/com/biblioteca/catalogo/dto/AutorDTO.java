package com.biblioteca.catalogo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {
    @JsonAlias("name")
    private String nombre;
    @JsonAlias("birth_year")
    private Integer anioNacimiento;
    @JsonAlias("death_year")
    private Integer anioFallecimiento;


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre: ").append(nombre);

        if (anioNacimiento == null && anioFallecimiento == null) {
            builder.append("\n  Información incompleta.");
        } else {
            if (anioNacimiento != null) {
                builder.append("\n  Año de Nacimiento: ")
                        .append(anioNacimiento < 0 ? (-anioNacimiento) + " a.C." : anioNacimiento);
            }
            if (anioFallecimiento != null) {
                builder.append("\n  Año de Fallecimiento: ")
                        .append(anioFallecimiento < 0 ? (-anioFallecimiento) + " a.C." : anioFallecimiento);
            }
        }
        return builder.toString();
    }


}
