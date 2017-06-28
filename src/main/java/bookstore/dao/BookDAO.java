package bookstore.dao;

import bookstore.model.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(long id);

    Book getBookById(long id);

    List<Book> getAllBooks();
}
