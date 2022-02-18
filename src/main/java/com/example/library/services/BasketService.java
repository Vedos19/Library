package com.example.library.services;

import com.example.library.interfaces.IBasketRepository;
import com.example.library.interfaces.IBasketService;
import com.example.library.models.Basket;
import com.example.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService implements IBasketService {

    @Autowired
    private IBasketRepository basketRepository;
    Basket basket = new Basket();

    public List<Book> getBasketBooks(){
        return basket.getBasketBooks();
    }
}
