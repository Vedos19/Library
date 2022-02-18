package com.example.library.models;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int id;
    private List<Book> basket_books = new ArrayList<>();

    public Basket(int id) {
        this.id = id;
    }

    public Basket() {}

    public boolean checkIfBookIsInBasketById(int book_id){
        for(Book book : basket_books){
            if(book.getId() == book_id){
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
        if(!checkIfBookIsInBasketById(book.getId())){
            System.out.println("Produktu nie ma już w koszyku!");
        }
        else{
            basket_books.remove(book);
            book.addQuantityByOne();
        }
    }

    public List<Book> getBasketBooks(){
        return basket_books;
    }

    public void clearBasket() {
        this.basket_books = new ArrayList<>();
    }
}
