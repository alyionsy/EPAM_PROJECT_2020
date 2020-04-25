package service;

import domain.Book;

import java.util.List;

public interface BookService {
    boolean create(Book book);
    Book read(int id);
    boolean update(Book book);
    boolean delete(int id);

    List<Book> findByYear(int year);
    List<Book> findByName(String name);
    List<Book> findByAuthorID(int id);

    void listAllBooks();
    void showBook(int id);
}
