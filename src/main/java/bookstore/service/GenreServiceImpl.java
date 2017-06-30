package bookstore.service;

import bookstore.dao.GenreDAO;
import bookstore.model.Genre;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenreServiceImpl implements GenreService {

    private GenreDAO genreDAO;

    public void setGenreDAO(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Override
    @Transactional
    public void addGenre(Genre genre) {
        genreDAO.addGenre(genre);
    }

    @Override
    @Transactional
    public void updateGenre(Genre genre) {
        genreDAO.updateGenre(genre);
    }

    @Override
    @Transactional
    public void removeGenre(long id) {
        genreDAO.removeGenre(id);
    }

    @Override
    @Transactional
    public Genre getGenreById(long id) {
        return genreDAO.getGenreById(id);
    }

    @Override
    @Transactional
    public List<Genre> getAllGenres() {
        return genreDAO.getAllGenres();
    }
}
