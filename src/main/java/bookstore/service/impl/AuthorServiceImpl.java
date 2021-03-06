package bookstore.service.impl;

import bookstore.dao.AuthorDAO;
import bookstore.model.Author;
import bookstore.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        authorDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }

    @Override
    @Transactional
    public void removeAuthor(long id) {
        authorDAO.removeAuthor(id);
    }

    @Override
    @Transactional
    public Author getAuthorkById(long id) {
        return authorDAO.getAuthorkById(id);
    }

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }
}
