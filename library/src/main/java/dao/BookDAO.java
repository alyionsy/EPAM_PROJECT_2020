package dao;

import domain.Book;

import java.util.List;

public interface BookDAO extends GenericDAO<Book> {
    List<Book> findByYear(int year);
    List<Book> findByName(String name);
    List<Book> findByAuthorID(int id);
}
