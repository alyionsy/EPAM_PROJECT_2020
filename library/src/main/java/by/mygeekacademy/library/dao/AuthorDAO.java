package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.domain.Author;

import java.util.LinkedList;

public interface AuthorDAO extends GenericDAO<Author> {
    int countAll();
    LinkedList<Author> readPage(int number);
}
