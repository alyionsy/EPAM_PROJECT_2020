package service.impl;

import dao.BookDAO;
import dao.DAOFactory;
import domain.Book;
import exception.ValidationException;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private static final int MIN_YEAR = 1000;
    private static final BookDAO dao = DAOFactory.getBookDAO();

    @Override
    public boolean create(Book book) {
        checkBook(book);
        return dao.create(book);
    }

    @Override
    public Book read(int id) {
        return dao.read(id);
    }

    @Override
    public boolean update(Book book) {
        checkBook(book);
        return dao.update(book);
    }

    @Override
    public boolean delete(int id) {
//        if (id < 0) {
//            throw new ValidationException("Invalid book");
//        }
        return dao.delete(id);
    }

    @Override
    public Book findByYear(int year) {
        return dao.findByYear(year);
    }

    @Override
    public Book findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Book findByAuthorID(int id) {
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
        System.out.println(dao.readAll().get(id));
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
