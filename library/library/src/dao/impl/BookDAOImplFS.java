package dao.impl;

import dao.BookDAO;
import domain.Book;
import domain.serializator.BookSerializator;

import java.util.List;

public class BookDAOImplFS implements BookDAO {

    public static final String FILE_NAME = "src/res/bookData.txt";

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
        BookSerializator sz = new BookSerializator();
        boolean b = sz.serialization(entity, FILE_NAME);
        return entity;
    }

    @Override
    public Book read(long id) {
        return null;
    }

    @Override
    public List<Book> readAll() {
        return null;
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public void delete(Book entity) {

    }

}
