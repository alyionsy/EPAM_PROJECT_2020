package service.impl;

import dao.AuthorDAO;
import dao.DAOFactory;
import domain.Author;
import domain.Order;
import exception.ValidationException;
import service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private static final AuthorDAO dao = DAOFactory.getAuthorDAO();

    @Override
    public boolean create(Author author) {
        checkAuthor(author);
        return dao.create(author);
    }

    @Override
    public Author read(int id) {
        return dao.read(id);
    }

    @Override
    public boolean update(Author author) {
        checkAuthor(author);
        return dao.update(author);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public void listAllAuthors() {
        List<Author> authors = dao.readAll();
        for (Author author : authors) {
            System.out.println(author + "\n");
        }
    }

    @Override
    public void showAuthor(int id) {
        System.out.println(dao.readAll().get(id));
    }

    private void checkAuthor(Author author) {
        if (author == null) {
            throw new ValidationException("Invalid author.");
        }

        String name = author.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name is required.");
        }
    }
}
