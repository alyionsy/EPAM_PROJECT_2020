package dao.impl;

import dao.BookDAO;
import domain.Book;
import domain.DataBase;
import domain.Order;
import domain.Reader;

import java.util.List;

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
    public List<Book> readAll() {
        return DataBase.getAllBooks();
    }

    @Override
    public Reader update(Book entity) {
        for (Book book: DataBase.getAllBooks()) {
            if (book.getId().equals(entity.getId())) {
                book.setName(entity.getName());
                book.setAuthor(entity.getAuthor());
                book.setDescription(entity.getDescription());
            }
        }
        for (Order order : DataBase.getAllOrders()) {
            if (entity.getId().equals(order.getBook().getId())) {
                order.getBook().setName(entity.getName());
                order.getBook().setAuthor(entity.getAuthor());
                order.getBook().setDescription(entity.getDescription());
            }
        }
        DataBase.writeAll();
        return null;
    }

    @Override
    public void delete(Book entity) {
        DataBase.getAllOrders().removeIf(order -> order.getBook().getId() == entity.getId());
        DataBase.getAllBooks().removeIf(book -> book.getId().equals(entity.getId()));
        DataBase.writeAll();
    }

}
