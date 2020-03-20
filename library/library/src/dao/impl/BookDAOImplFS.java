package dao.impl;

import dao.BookDAO;
import domain.Book;
import domain.DataBase;
import domain.serializator.BookSerializator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImplFS implements BookDAO {

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
        DataBase db = new DataBase();
        db.addBook(entity);
        return entity;
    }

    @Override
    public Book read(long id) {
        return null;
    }

    @Override
    public List<Book> readAll() {
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public void delete(Book entity) {

    }

}
