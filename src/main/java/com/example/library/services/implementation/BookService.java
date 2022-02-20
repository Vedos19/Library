package com.example.library.services.implementation;

import com.example.library.dao.IBookRepository;
import com.example.library.models.Basket;
import com.example.library.models.Book;
import com.example.library.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;


    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

}