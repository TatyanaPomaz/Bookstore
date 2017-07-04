package bookstore.dao.impl;

import bookstore.dao.GenreDAO;
import bookstore.dao.impl.BookDAOImpl;
import bookstore.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GenreDAOImpl implements GenreDAO {
    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGenre(Genre genre) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(genre);
        logger.info("Genre successfully saved. Genre details: " + genre);
    }

    @Override
    public void updateGenre(Genre genre) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(genre);
        logger.info("Genre successfully updated. Genre details: " + genre);
    }

    @Override
    public void removeGenre(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Genre genre = (Genre) currentSession.load(Genre.class, new Long(id));

        if (genre != null) {
            currentSession.delete(genre);
        }
        logger.info("Genre successfully removed. Genre details: " + genre);
    }

    @Override
    public Genre getGenreById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Genre genre = (Genre) currentSession.load(Genre.class, new Long(id));
        logger.info("Genre successfully loaded. Genre details: " + genre);

        return genre;
    }

    @Override
    public List<Genre> getAllGenres() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Genre> genreList = currentSession.createQuery("from Genre").list();

        for (Genre genre : genreList) {
            logger.info("Genre list : " + genre);
        }

        return genreList;
    }
}
