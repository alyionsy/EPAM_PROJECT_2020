package dao.impl;

import dao.BookDAO;
import domain.Book;
import domain.DataBase;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookDAOImpl implements BookDAO {

    public static final int MAX_SIZE = 1000;

    @Override
    public Book findByName(String name) {
        for (Book book : DataBase.getAllBooks()) {
            if (book.getName().equals(name))
                return book;
        }
        return null;
    }

    @Override
    public Book findByAuthor(String author) {
        for (Book book : DataBase.getAllBooks()) {
            if (book.getAuthor().equals(author))
                return book;
        }
        return null;
    }

    @Override
    public Book create(Book entity) throws IOException {
        if (!DataBase.getAllBooks().isEmpty()) {
            entity.setId(DataBase.getAllBooks().get(DataBase.getAllBooks().size() - 1).getId() + 1);
        }
        else {
            entity.setId((long) 1);
        }
        DataBase.addBook(entity);
        DataBase.writeAll();
        return entity;
    }

    @Override
    public Book read(long id) {
        for (Book book : DataBase.getAllBooks()) {
            if (book.getId().equals(id))
                return book;
        }
        return null;
    }

    @Override
    public List<Book> readAll() throws IOException, ClassNotFoundException {
        return DataBase.getAllBooks();
    }

    @Override
    public void update(Book entity) throws IOException {
        for (Book book: DataBase.getAllBooks()) {
            if (book.getId().equals(entity.getId())) {
                book.setName(entity.getName());
                book.setAuthor(entity.getAuthor());
                book.setDescription(entity.getDescription());
            }
        }
        DataBase.writeAll();
    }

    @Override
    public void delete(Book entity) throws IOException {
        DataBase.getAllBooks().removeIf(book -> book.getId().equals(entity.getId()));
        DataBase.writeAll();
    }

}
