package bookstore.dao.impl;

import bookstore.dao.BookDAO;
import bookstore.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(book);
        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(book);
        logger.info("Book successfully updated. Book details: " + book);
    }

    @Override
    public void removeBook(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Book book = (Book) currentSession.load(Book.class, new Long(id));

        if (book != null) {
            currentSession.delete(book);
        }
        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Book getBookById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Book book = (Book) currentSession.load(Book.class, new Long(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Book> bookList = currentSession.createQuery("from Book").list();

        for (Book book : bookList) {
            logger.info("Book list : " + book);
        }

        return bookList;
    }
}
