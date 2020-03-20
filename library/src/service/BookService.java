package service;

import domain.Book;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BookService {
    Book create(Book book) throws IOException;
    Book update(Book book) throws IOException;
    void delete(Book book) throws IOException;
    Book findByName(String name);
    Book findByAuthor(String author);
    void listAllBooks() throws IOException, ClassNotFoundException;
}
