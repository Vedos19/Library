package com.example.library.services.implementation;

import com.example.library.dao.IBookRepository;
import com.example.library.models.Basket;
import com.example.library.models.Book;
import com.example.library.services.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService implements IBasketService {

    @Autowired
    private IBookRepository bookRepository;
    Basket basket = new Basket();

    public void addBookToBasket(int book_id){
        Book book = bookRepository.getById(book_id);

        int book_isbn = book.getIsbn();

        if(!basket.checkIfBookIsInBasketByIsbn(book_isbn)){
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

    public void removeBook(int book_id){
        System.out.println("BOOK ID Z BSERVICE: " + book_id);
        int book_isbn = bookRepository.getById(book_id).getIsbn();
        System.out.println("KSIAZKA: " + bookRepository.getById(book_id));
        if(basket.checkIfBookIsInBasketByIsbn(book_isbn)){
            basket.removeBook(bookRepository.getById(book_id));
            bookRepository.getById(book_id).increaseQuantityByOne();
            bookRepository.save(bookRepository.getById(book_id));
        }
    }

    public List<Book> getBasketBooks(){
        return basket.getBasketBooks();
    }
}
