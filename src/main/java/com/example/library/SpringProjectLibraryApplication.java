package com.example.library;

import com.example.library.interfaces.IBookRepository;
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
        bookRepository.save(new Book(5465, 1, 250, "Jak żyć z dużym penisem", "Konrad Rzepliński"));
        bookRepository.save(new Book(4564, 2, 270, "Jak znaleźć deklarację klasy", "Marek Szot"));
        bookRepository.save(new Book(3454, 0, 320, "Jak zrobić formę na ciastkach i czekoladzie", "Artur Gaik"));
        bookRepository.save(new Book(7837, 2, 170, "Jak chodzić tydzień w jednej koszulce", "Szymon Prochal"));
        bookRepository.save(new Book(3378, 3, 280, "Jak żyć z Hanną uwu", "Krzysztof Wlazło"));
        bookRepository.save(new Book(3548, 1, 280, "Jak żyć z bezczelnym chamem", "Natalia Wcisło-Wlazło"));
    }
}
