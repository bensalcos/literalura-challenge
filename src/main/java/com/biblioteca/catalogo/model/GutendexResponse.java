package com.biblioteca.catalogo.model;

import com.biblioteca.catalogo.dto.LibroDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResponse {

    private List<LibroDTO> results;
    private int totalCount;

    @Override
    public String toString() {
        return "GutendexResponse{" +
                "results=" + results +
                ", totalCount=" + totalCount +
                '}';
    }
}
