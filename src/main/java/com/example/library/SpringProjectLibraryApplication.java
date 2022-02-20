package com.example.library;

import com.example.library.dao.IBookRepository;
import com.example.library.models.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProjectLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner runProducts (IBookRepository bookRepository) {
        return (args -> {
            insertBooks(bookRepository);
            System.out.println(bookRepository.findAll());
        });
    }

    public void insertBooks(IBookRepository bookRepository) {
        bookRepository.save(new Book(5465, 2, 960, "Ostatnia więź. Kronika nieciosanego tronu. Tom 3", "Staveley Brian"));
        bookRepository.save(new Book(4564, 1, 1425, "Władca Pierścieni: Drużyna Pierścienia / Dwie wieże / Powrót króla", "Tolkien John Ronald Reuel"));
        bookRepository.save(new Book(3454, 0, 176, "451 stopni Fahrenheita", "Bradbury Ray"));
        bookRepository.save(new Book(7837, 2, 170, "Warhammer 2 ed. RPG - Podręcznik Główny", "Copernicus Corporation"));
        bookRepository.save(new Book(3378, 3, 592, "Uniwersum Metro 2033. Metro 2033", "Glukhovsky Dmitry"));
    }
}
