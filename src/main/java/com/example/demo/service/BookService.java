package com.example.demo.service;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.repository.BookRepository; // Asegúrate de importar correctamente

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final String API_URL = "https://gutendex.com/books/";

    private final RestTemplate restTemplate;
    private final BookRepository bookRepository; // Asegúrate de que sea final
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(RestTemplate restTemplate, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository; // Asignación del repositorio inyectado
        this.authorRepository = authorRepository;
    }

    public void searchBooksByTitle(String title) {
        String apiUrl = API_URL + "?title=" + title;
        Example response = restTemplate.getForObject(apiUrl, Example.class);

        if (response != null && response.results != null) {
            for (Result book : response.results) {
                Book bookEntity = new Book();

                bookEntity.setTitle(book.title);
                bookEntity.setDownload_count(book.download_count);

                List<Author> authors = new ArrayList<>();
                if (book.authors != null) {
                    for (com.example.demo.service.Author authorResponse : book.authors) {
                        Author author = new Author();
                        author.setName(authorResponse.name);
                        author.setBirthYear(authorResponse.birth_year);
                        author.setDeathYear(authorResponse.death_year);
                        authors.add(author);
                    }
                }

                List<String> languages = new ArrayList<>();
                if (book.languages != null) {
                    for (String lenguaje : book.languages) {
                        languages.add(lenguaje);
                    }
                }
                bookEntity.setLanguages(languages);
                bookEntity.setAuthors(authors);
                bookRepository.save(bookEntity);
            }
        } else {
            System.out.println("No se encontraron libros con el título '" + title + "'.");
        }
    }


    public void listarLibros() {
        List<Book> libros = bookRepository.findAll();

        for (Book libro : libros) {
            System.out.println("--- LIBRO ---");
            System.out.println("Título: " + libro.getTitle());
            System.out.print("Autor: ");
            for (int i = 0; i < libro.getAuthors().size(); i++) {
                System.out.print(libro.getAuthors().get(i).getName());
                if (i < libro.getAuthors().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.print("Idiomas: ");
            for (int i = 0; i < libro.getLanguages().size(); i++) {
                System.out.print(libro.getLanguages().get(i));
                if (i < libro.getLanguages().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("Número de descargas: " + libro.getDownload_count());
            System.out.println();
        }
    }

    public void listarAutores() {
        List<Author> autores = authorRepository.findAll();

        for (Author autor : autores) {
            System.out.println("--- AUTOR ---");
            System.out.println("Nombre: " + autor.getName());
            System.out.println("Fecha de nacimiento: " + autor.getBirthYear());
            System.out.println("Fecha de fallecimiento: " + autor.getDeathYear());

            // Obtener los libros del autor
            List<Book> libros = bookRepository.findByAuthorsContaining(autor);

            System.out.print("Libros: ");
            for (int i = 0; i < libros.size(); i++) {
                System.out.print(libros.get(i).getTitle());
                if (i < libros.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
            System.out.println();
        }
    }

    public void listarAutoresVivosEnAnio(int year) {
        List<Author> autores = authorRepository.findAll();

        List<Author> autoresVivos = autores.stream()
                .filter(autor -> autor.getDeathYear() == null || autor.getDeathYear() > year)
                .collect(Collectors.toList());

        if (autoresVivos.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año " + year);
        } else {
            System.out.println("--- AUTORES VIVOS EN EL AÑO " + year + " ---");
            for (Author autor : autoresVivos) {
                System.out.println("Nombre: " + autor.getName());
                System.out.println("Fecha de nacimiento: " + autor.getBirthYear());
                System.out.println("Fecha de fallecimiento: " + (autor.getDeathYear() != null ? autor.getDeathYear() : "No fallecido"));
                System.out.println();
            }
        }
    }

    public void listarLibrosPorIdioma(String idioma) {
        List<Book> libros = bookRepository.findByLanguagesContaining(idioma);

        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros en el idioma '" + idioma + "'");
        } else {
            System.out.println("--- LIBROS EN IDIOMA '" + idioma + "' ---");
            for (Book libro : libros) {
                System.out.println("Título: " + libro.getTitle());
                System.out.print("Autor: ");
                for (int i = 0; i < libro.getAuthors().size(); i++) {
                    System.out.print(libro.getAuthors().get(i).getName());
                    if (i < libro.getAuthors().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
                System.out.println("Número de descargas: " + libro.getDownload_count());
                System.out.println();
            }
        }
    }

}
