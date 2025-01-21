package com.biblioteca.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.biblioteca.catalogo.service.LibroService;
import com.biblioteca.catalogo.service.AutorService;
import com.biblioteca.catalogo.service.GutendexService;

import java.util.Scanner;

@Controller
public class MenuController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private GutendexService gutendexService = new GutendexService();

    public void exhibirMenu(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú del Catálogo de Libros ===");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar todos los autores");
            System.out.println("4. Listar autores vivos en un año específico");
            System.out.println("5. Buscar por autor");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            String query;
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el Título del libro: ");
                    query = scanner.nextLine();
                    gutendexService.buscarLibrosAPI(query);
                    break;
                case 2:
                    gutendexService.listarLibrosAPI();
                    break;
                case 3:
                    gutendexService.listarAutoresAPI();
                    break;
                case 4:
                    System.out.print("Introduce el año: ");
                    String anio = scanner.nextLine();
                    gutendexService.buscarAutoresAnio(anio);
                    break;
                case 5:
                    System.out.print("Introduce el nombre del Autor: ");
                    query = scanner.nextLine();
                    gutendexService.buscarLibrosAPI(query);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
