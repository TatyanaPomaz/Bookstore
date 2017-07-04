package bookstore.dao;

import bookstore.model.Book;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(long id);

    Book getBookById(long id);

    List<Book> getAllBooks();
}
