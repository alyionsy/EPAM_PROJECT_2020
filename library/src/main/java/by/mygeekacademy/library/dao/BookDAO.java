package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.domain.Book;

import java.util.LinkedList;
import java.util.List;

public interface BookDAO extends GenericDAO<Book> {
    List<Book> findByYear(int year);
    List<Book> findByName(String name);
    List<Book> findByAuthorID(int id);
    int countAll();
    LinkedList<Book> readPage(int number);
}
