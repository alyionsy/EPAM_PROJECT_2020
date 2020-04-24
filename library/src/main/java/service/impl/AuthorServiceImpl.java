package service.impl;

import domain.Author;
import exception.ValidationException;
import service.AuthorService;

import java.io.IOException;

public class AuthorServiceImpl implements AuthorService {
    @Override
    public Author create(Author author) throws IOException {
        if (author == null) {
            throw new ValidationException("Invalid author");
        }

        String name = author.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name is required");
        }

        return dao.create(author);
    }

    @Override
    public Author update(Author author) throws IOException {
        return null;
    }

    @Override
    public void delete(Author author) throws IOException {

    }

    @Override
    public Author findByName(String name) {
        return null;
    }

    @Override
    public Author read(long id) {
        return null;
    }

    @Override
    public void listAllBooks() throws IOException, ClassNotFoundException {

    }
}
