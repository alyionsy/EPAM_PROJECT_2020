package dao;

import domain.Book;

public interface BookDAO extends GenericDAO<Book> {
    Book findByName(String name);
    Book findByAuthor(String author);
}
