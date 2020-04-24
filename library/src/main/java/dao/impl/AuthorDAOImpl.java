package dao.impl;

import dao.AuthorDAO;
import domain.Author;
import domain.Reader;

import java.io.IOException;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public boolean create(Author entity) {
        return false;
    }

    @Override
    public Author read(int id) {
        return null;
    }

    @Override
    public List<Author> readAll() {
        return null;
    }

    @Override
    public boolean update(Author entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
