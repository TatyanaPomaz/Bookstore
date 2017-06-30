package bookstore.service;

import bookstore.model.Author;

import java.util.List;

public interface AuthorService {
    void addAuthor(Author author);

    void updateAuthor(Author author);

    void removeAuthor(long id);

    Author getAuthorkById(long id);

    List<Author> getAllAuthors();
}
