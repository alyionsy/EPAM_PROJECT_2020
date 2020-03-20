package dao.impl;

import dao.BookDAO;
import domain.Book;
import domain.DataBase;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookDAOImpl implements BookDAO {

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
    public Book create(Book entity) {
        entity.setId(ThreadLocalRandom.current().nextLong());
        DataBase.addBook(entity);
        return entity;
    }

    @Override
    public Book read(long id) {
        return null;
    }

    @Override
    public List<Book> readAll() {
        return DataBase.getAllBooks();
    }

    @Override
    public void update(Book entity) {
        for (Book book: DataBase.getAllBooks()) {
            if (book.getId().equals(entity.getId())) {
                book.setName(entity.getName());
                book.setAuthor(entity.getAuthor());
                book.setDescription(entity.getDescription());
            }
        }
    }

    @Override
    public void delete(Book entity) {
        DataBase.getAllBooks().removeIf(book -> book.getId().equals(entity.getId()));
    }

}
