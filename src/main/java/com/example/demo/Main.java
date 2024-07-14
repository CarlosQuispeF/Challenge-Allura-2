package com.example.demo;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
@Import(AppConfig.class) // Importa la configuración de la clase AppConfig
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        Main demoApp = context.getBean(Main.class);
        demoApp.displayMenu(context.getBean(BookRepository.class), context.getBean(AuthorRepository.class));

    }

    private void displayMenu(BookRepository bookRepository, AuthorRepository authorRepository) {
        RestTemplate restTemplate = new RestTemplate();
        BookService bookService = new BookService(restTemplate, bookRepository, authorRepository);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("Bienvenido al Menú:");
            System.out.println("1. Buscar libro por titulo");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. listar autores vivos en un determinado año");
            System.out.println("5. listar libros por idioma");
            System.out.println("6. Salir");

            System.out.print("Ingrese su elección: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String titulo = scanner.nextLine();
                    bookService.searchBooksByTitle(titulo);
                    System.out.println("Se registro correctamente");
                    break;
                case 2:
                    bookService.listarLibros();
                    break;
                case 3:
                    bookService.listarAutores();
                    break;
                case 4:
                    System.out.print("Ingrese el año para listar autores vivos: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    bookService.listarAutoresVivosEnAnio(year);
                    break;
                case 5:
                    displaySubmenuLibrosPorIdioma(bookService);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    private void displaySubmenuLibrosPorIdioma(BookService bookService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el idioma:");
        System.out.println("1. Español (es)");
        System.out.println("2. Inglés (en)");
        System.out.print("Ingrese su elección: ");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "es":
                bookService.listarLibrosPorIdioma("es");
                break;
            case "en":
                bookService.listarLibrosPorIdioma("en");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
}
