package com.example.library.services;

import com.example.library.interfaces.IBookRepository;
import com.example.library.interfaces.IBookService;
import com.example.library.models.Basket;
import com.example.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;
    Basket basket = new Basket();

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addBookToBasket(int book_id){
        Book book = bookRepository.getById(book_id);

        if(!basket.checkIfBookIsInBasketById(book_id)){
            if(book.getQuantity() > 0){
                Book dummy_book = new Book();
                dummy_book.setId(book.getId());
                dummy_book.setIsbn(book.getIsbn());
                dummy_book.setPages(book.getPages());
                dummy_book.setAuthor(book.getAuthor());
                dummy_book.setTitle(book.getTitle());
                dummy_book.setQuantity(1);

                basket.addBook(dummy_book);
                book.subtractQuantityByOne();
                bookRepository.save(book);
            }
        }
    }
}