# Challenge LiterAlura

Este proyecto es parte del **Challenge de Alura Latam** del programa **Oracle Next Education (ONE)**. Desarrollado en Java con Spring Boot, tiene como objetivo integrar y consumir la API de Gutendex para realizar diversas operaciones sobre libros y autores.

## 📚 Características

- **Buscar libros:** Realiza búsquedas de libros según un término específico.
- **Buscar autores:** Realiza búsquedas de libros según su autor.
- **Listar autores:** Obtén una lista única de autores basada en los datos de los libros.
- **Listar libross:** Obtén una lista única de libros.
- **Filtrar por año:** Encuentra autores vivos en un año definido.
- **Integración con PostgreSQL:** Almacena los datos obtenidos en una base de datos para facilitar su acceso.

## 🛠️ Tecnologías

- **Lenguaje:** Java
- **Framework:** Spring Boot
- **Base de Datos:** PostgreSQL
- **API Externa:** Gutendex API

## 🚀 Requisitos

- Java 17+
- Spring Boot
- PostgreSQL
- Maven

## ⚙️ Configuración

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/nombre-repositorio.git
2. **Configura tu conexión a la base de datos PostgreSQL:**
Modifica el archivo application.properties ubicado en src/main/resources:
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
  spring.datasource.username=tu_usuario
  spring.datasource.password=tu_contraseña
  ```

3. **Ejecuta el proyecto:**

  ```bash
  ./mvnw spring-boot:run
