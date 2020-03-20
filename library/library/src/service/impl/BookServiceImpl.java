package service.impl;

import dao.BookDAO;
import dao.DAOFactory;
import domain.Book;
import exception.ValidationException;
import service.BookService;

public class BookServiceImpl implements BookService {

    private static final BookDAO dao = DAOFactory.getBookDAO();

    @Override
    public Book create(Book book) {
        if (book == null) {
            throw new ValidationException("Invalid book");
        }

        String name = book.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name is required");
        }

        String author = book.getAuthor();
        if (author == null || author.isEmpty()) {
            throw new ValidationException("Author is required");
        }

        return dao.create(book);
    }

    @Override
    public Book update(Book book) {
        if (book == null) {
            throw new ValidationException("Invalid book");
        }

        String name = book.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name is required");
        }

        String author = book.getAuthor();
        if (author == null || author.isEmpty()) {
            throw new ValidationException("Author is required");
        }

        return dao.update(book);
    }
}
