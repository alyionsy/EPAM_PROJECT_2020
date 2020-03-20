package service.impl;

import dao.BookDAO;
import dao.DAOFactory;
import domain.Book;
import exception.ValidationException;
import service.BookService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private static final BookDAO dao = DAOFactory.getBookDAO();

    @Override
    public Book create(Book book) throws IOException {
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
    public Book update(Book book) throws IOException {
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

        dao.update(book);
        return book;
    }

    @Override
    public void delete(Book book) throws IOException {
        if (book == null) {
            throw new ValidationException("Invalid book");
        }

        dao.delete(book);
    }

    @Override
    public Book findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Book findByAuthor(String author) {
        return dao.findByAuthor(author);
    }

    @Override
    public void listAllBooks() throws IOException, ClassNotFoundException {
        List<Book> allBooks = dao.readAll();
        for (Book book : allBooks) {
            System.out.println(book + "\n");
        }
        System.out.println(allBooks.size() + "\n");
    }
}
