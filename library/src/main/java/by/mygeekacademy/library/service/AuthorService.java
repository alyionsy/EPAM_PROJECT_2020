package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Author;

public interface AuthorService {
    boolean create(Author author);
    Author read(int id);
    boolean update(Author author);
    boolean delete(int id);

    void listAllAuthors();
    void showAuthor(int id);
    int countAll();
    void listPage(int number);
}
