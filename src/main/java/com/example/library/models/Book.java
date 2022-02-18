package com.example.library.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int isbn;
    private int quantity;
    private int pages;
    private String title;
    private String author;
    private String availability;

    public Book(int isbn, int quantity, int pages, String title, String author) {
        this.isbn = isbn;
        this.quantity = quantity;
        this.pages = pages;
        this.title = title;
        this.author = author;

        if(quantity > 0){
            this.availability = "w magazynie";
        }
        else{
            this.availability = "niedostępna";
        }
    }

    public Book() {
    }

    public int getId() {
        return id;
    }
    public int getIsbn() {
        return isbn;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPages() {
        return pages;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getAvailability() {
        return availability;
    }

    public void setId(int id) {
        this.isbn = id;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", quantity=" + quantity +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }

    public void addQuantityByOne(){
        setQuantity(getQuantity()+1);

        if(quantity > 0){
            this.availability = "w magazynie";
        }
        else{
            this.availability = "niedostępna";
        }
    }

    public void subtractQuantityByOne(){
        setQuantity(getQuantity()-1);

        if(quantity > 0){
            this.availability = "w magazynie";
        }
        else{
            this.availability = "niedostępna";
        }
    }
}