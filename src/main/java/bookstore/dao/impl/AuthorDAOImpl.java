package bookstore.dao.impl;

import bookstore.dao.AuthorDAO;
import bookstore.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAuthor(Author author) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(author);
        logger.info("Author successfully saved. Author details: " + author);
    }

    @Override
    public void updateAuthor(Author author) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(author);
        logger.info("Author successfully updated. Author details: " + author);
    }

    @Override
    public void removeAuthor(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Author author = (Author) currentSession.load(Author.class, new Long(id));

        if (author != null) {
            currentSession.delete(author);
        }
        logger.info("Author successfully removed. Author details: " + author);
    }

    @Override
    public Author getAuthorkById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Author author = (Author) currentSession.load(Author.class, new Long(id));
        logger.info("Author successfully loaded. Author details: " + author);

        return author;
    }

    @Override
    public List<Author> getAllAuthors() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Author> authorList = currentSession.createQuery("from Author").list();

        for (Author author : authorList) {
            logger.info("Author list : " + author);
        }

        return authorList;
    }
}
