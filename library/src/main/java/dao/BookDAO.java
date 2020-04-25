package dao;

import domain.Book;

public interface BookDAO extends GenericDAO<Book> {
    Book findByYear(int year);
    Book findByName(String name);
    Book findByAuthorID(int id);
}
