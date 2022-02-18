import com.example.library.models.Book;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private int id;
    private int user_id;
    private Set<Book> list_of_books =new HashSet<>();
    private LocalDateTime date;

    public Order(int id, int user_id, Set<Book> list_of_books, LocalDateTime date) {
        this.id = id;
        this.user_id = user_id;
        this.list_of_books = list_of_books;
        this.date = date;
    }
    public Order() {
    }

    public int getId() {
        return id;
    }
    public int getUser_id() {
        return user_id;
    }
    public Set<Book> getList_of_books() {
        return list_of_books;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setList_of_books(Set<Book> list_of_books) {
        this.list_of_books = list_of_books;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}