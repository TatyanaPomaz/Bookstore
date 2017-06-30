package bookstore.dao;

import bookstore.model.Genre;

import java.util.List;

public interface GenreDAO {
    void addGenre(Genre genre);

    void updateGenre(Genre genre);

    void removeGenre(long id);

    Genre getGenreById(long id);

    List<Genre> getAllGenres();
}
