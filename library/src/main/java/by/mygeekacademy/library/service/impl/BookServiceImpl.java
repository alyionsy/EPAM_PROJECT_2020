package by.mygeekacademy.library.service.impl;

import by.mygeekacademy.library.dao.BookDAO;
import by.mygeekacademy.library.dao.DAOFactory;
import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.domain.Book;
import by.mygeekacademy.library.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.PersistenceException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static final int MIN_YEAR = 1000;
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class.getName());
    private static final BookDAO dao = DAOFactory.getBookDAO();

    @Override
    public void create(Book book) {
        checkBook(book);
        dao.create(book);
    }

    @Override
    public Book read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public List<Book> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(Book book) {
        checkBook(book);
        dao.update(book);
    }

    @Override
    public void delete(Book book) {
        try {
            dao.delete(book);
        } catch (PersistenceException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<Book> findByYear(int year) {
        return dao.findByYear(year);
    }

    @Override
    public List<Book> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Book> findByAuthorID(int id) {
        return dao.findByAuthorID(id);
    }


    @Override
    public void listAllBooks() {
        List<Book> allBooks = dao.readAll();
        for (Book book : allBooks) {
            System.out.println(book + "\n");
        }
    }

    @Override
    public void showBook(int id) {
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
        List<Book> page = dao.readPage(pageNumber);
        for (Book book : page) {
            System.out.println("\n" + book);
        }
    }

    private void checkBook(Book book) {
        if (book == null) {
            throw new ValidationException("Invalid book.");
        }

        String name = book.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name is required.");
        }

        int authorID = book.getAuthorID();
        if (authorID < 0) {
            throw new ValidationException("Invalid author ID.");
        }

        int year = book.getYear();
        if (year < MIN_YEAR) {
            throw new ValidationException("Invalid book year");
        }
    }
}
