package com.example.library.models;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int id;
    private List<Book> basket_books = new ArrayList<>();

    public Basket() {
    }

    public boolean checkIfBookIsInBasketByIsbn(int book_isbn){
        for(Book book : basket_books){
            if(book.getIsbn() == book_isbn){
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book){
        this.basket_books.add(book);
        book.subtractQuantityByOne();
    }

    public void removeBook(Book book){
        this.basket_books.remove(book);
        book.increaseQuantityByOne();
    }

    public List<Book> getBasketBooks(){
        return basket_books;
    }
}
