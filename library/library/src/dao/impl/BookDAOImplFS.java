package dao.impl;

import dao.BookDAO;
import domain.Book;

import java.util.List;

public class BookDAOImplFS implements BookDAO {

    private String path = "src/res/data.txt";

    @Override
    public Book findByName(String name) {
        return null;
    }

    @Override
    public Book findByAuthor(String author) {
        return null;
    }

    @Override
    public Book create(Book entity) {
        return null;
    }

    @Override
    public Book read(long id) {
        return null;
    }

    @Override
    public List<Book> readAll() {
        List<Book> books;

    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public void delete(Book entity) {

    }
}
