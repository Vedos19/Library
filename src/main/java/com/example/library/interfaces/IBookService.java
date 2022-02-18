package com.example.library.interfaces;

import com.example.library.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    void addBookToBasket(int book_id);
}
