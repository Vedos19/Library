package com.example.library.controllers;

import com.example.library.dao.IBookRepository;
import com.example.library.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RESTController {

    private final IBookRepository iBookRepository;

    public RESTController(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @GetMapping("/byisbn/{isbn}")
    public List<Book> findByIsbn(@PathVariable int isbn) {
        return iBookRepository.findBookByIsbn(isbn);
    }
}

