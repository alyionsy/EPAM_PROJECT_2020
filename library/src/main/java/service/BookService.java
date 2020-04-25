package service;

import domain.Book;

public interface BookService {
    boolean create(Book book);
    Book read(int id);
    boolean update(Book book);
    boolean delete(int id);

    Book findByYear(int year);
    Book findByName(String name);
    Book findByAuthorID(int id);

    void listAllBooks();
    void showBook(int id);
}
