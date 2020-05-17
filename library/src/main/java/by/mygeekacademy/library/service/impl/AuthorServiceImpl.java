package by.mygeekacademy.library.service.impl;

import by.mygeekacademy.library.dao.DAOFactory;
import by.mygeekacademy.library.dao.AuthorDAO;
import by.mygeekacademy.library.domain.Author;
import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private static final AuthorDAO dao = DAOFactory.getAuthorDAO();

    @Override
    public void create(Author author) {
        checkAuthor(author);
        dao.create(author);
    }

    @Override
    public Author read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public void update(Author author) {
        checkAuthor(author);
        dao.update(author);
    }

    @Override
    public void delete(Author author) {
        dao.delete(author);
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
        if (dao.read(id).isEmpty()) {
            System.out.println("No such elements");
        } else {
            System.out.println(dao.read(id).get());
        }
    }

    @Override
    public int countAll() {
        return dao.countAll();
    }

    @Override
    public void listPage(int pageNumber) {
        List<Author> page = dao.readPage(pageNumber);
        for (Author author : page) {
            System.out.println("\n" + author);
        }
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
