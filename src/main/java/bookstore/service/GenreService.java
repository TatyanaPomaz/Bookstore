package bookstore.service;

import bookstore.model.Genre;

import java.util.List;

public interface GenreService {
    void addGenre(Genre genre);

    void updateGenre(Genre genre);

    void removeGenre(long id);

    Genre getGenreById(long id);

    List<Genre> getAllGenres();
}
