package bookstore.service.impl;

import bookstore.dao.BookDAO;
import bookstore.model.Book;
import bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(long id) {
        bookDAO.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookById(long id) {
        return bookDAO.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
}
