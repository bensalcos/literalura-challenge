package com.biblioteca.catalogo.service;

import com.biblioteca.catalogo.dto.LibroDTO;
import com.biblioteca.catalogo.model.GutendexResponse;
import com.biblioteca.catalogo.model.Libro;
import com.biblioteca.catalogo.repository.AutorRepository;
import com.biblioteca.catalogo.repository.LibroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class GutendexService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private static final String BASE_URL = "https://gutendex.com/";

    private final HttpClient httpClient = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void buscarLibrosAPI(String query) {
        String url = BASE_URL + "books?search=" + query.replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        System.out.println("URL: " + url);
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            if (response.statusCode() == 200) {
                GutendexResponse gutendexResponse = objectMapper.readValue(response.body(), GutendexResponse.class);
                List<LibroDTO> libros = gutendexResponse.getResults();
                libros.forEach(System.out::println);
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarAutoresAnio(String anio) {
        String url = BASE_URL + "books?author_year_start=" + anio + "&author_year_end=" + anio;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            if (response.statusCode() == 200) {
                GutendexResponse gutendexResponse = objectMapper.readValue(response.body(), GutendexResponse.class);
                List<LibroDTO> libros = gutendexResponse.getResults();
                libros.stream()
                        .flatMap(libro -> libro.getAutores().stream())
                        .distinct()
                        .forEach(System.out::println);
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarAutoresAPI() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+"books"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            if (response.statusCode() == 200) {
                GutendexResponse gutendexResponse = objectMapper.readValue(response.body(), GutendexResponse.class);
                List<LibroDTO> libros = gutendexResponse.getResults();
                libros.stream()
                        .flatMap(libro -> libro.getAutores().stream())
                        .distinct()
                        .forEach(System.out::println);
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarLibrosAPI() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+"books"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            if (response.statusCode() == 200) {
                GutendexResponse gutendexResponse = objectMapper.readValue(response.body(), GutendexResponse.class);
                List<LibroDTO> libros = gutendexResponse.getResults();
                libros.stream().forEach(System.out::println);


            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
