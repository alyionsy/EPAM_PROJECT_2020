package service;

import domain.Book;

public interface BookService {
    Book create(Book book);
    Book update(Book book);
    void delete(Book book);
    Book findByName(String name);
    Book findByAuthor(String author);
}
