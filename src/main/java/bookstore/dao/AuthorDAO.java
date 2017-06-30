package bookstore.dao;

import bookstore.model.Author;

import java.util.List;

public interface AuthorDAO {
    void addAuthor(Author author);

    void updateAuthor(Author author);

    void removeAuthor(long id);

    Author getAuthorkById(long id);

    List<Author> getAllAuthors();
}
