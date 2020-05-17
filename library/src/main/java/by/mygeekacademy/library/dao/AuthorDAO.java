package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.domain.Author;

import java.util.List;

public interface AuthorDAO extends GenericDAO<Author> {
    int countAll();
    List<Author> readPage(int number);
}
