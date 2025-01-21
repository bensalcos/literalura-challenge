package com.biblioteca.catalogo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Scanner;
import com.biblioteca.catalogo.controller.MenuController;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner {

	@Autowired
	private MenuController menuController;

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		menuController.exhibirMenu(scanner);
		scanner.close();
	}
}
