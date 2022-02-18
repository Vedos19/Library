package com.example.library.controllers;

import com.example.library.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("get_books", this.bookService.getBooks());
        return "books";
    }

    @GetMapping("books/{book_id}")
    public String addBook(@PathVariable int book_id) {
        bookService.addBookToBasket(book_id);
        return "redirect:/books";
    }
}