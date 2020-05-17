package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Book;

import java.util.List;

public interface BookService {
    void create(Book book);
    Book read(int id);
    void update(Book book);
    void delete(Book book);

    List<Book> findByYear(int year);
    List<Book> findByName(String name);
    List<Book> findByAuthorID(int id);

    void listAllBooks();
    void showBook(int id);
    int countAll();
    void listPage(int number);
}
