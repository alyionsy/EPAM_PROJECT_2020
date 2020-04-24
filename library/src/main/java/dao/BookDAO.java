package main.java.dao;

import main.java.domain.Book;

public interface BookDAO extends GenericDAO<Book> {
    Book findByName(String name);
    Book findByAuthor(String author);
}
