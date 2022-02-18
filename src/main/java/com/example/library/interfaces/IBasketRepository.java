package com.example.library.interfaces;

import com.example.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasketRepository  extends JpaRepository<Book, Integer> {
}
