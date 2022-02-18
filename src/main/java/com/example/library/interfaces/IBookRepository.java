package com.example.library.interfaces;

import com.example.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByIsbn(Integer isbn);
}
