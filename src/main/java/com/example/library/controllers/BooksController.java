package com.example.library.controllers;

import com.example.library.services.IBasketService;
import com.example.library.services.IBookService;
import com.example.library.services.implementation.BasketService;
import com.example.library.services.implementation.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BooksController {

    private final IBasketService basketService;
    private final IBookService bookService;

    public BooksController(BookService bookService, BasketService basketService) {
        this.bookService = bookService;
        this.basketService = basketService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("get_books", this.bookService.getBooks());
        return "books";
    }

    @GetMapping("books/add/{book_id}")
    public String addBook(@PathVariable int book_id) {
        basketService.addBookToBasket(book_id);
        return "redirect:/books";
    }
}