package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Author;

import java.util.List;

public interface AuthorService {
    void create(Author author);
    Author read(int id);
    List<Author> readAll();
    void update(Author author);
    void delete(Author author);

    void listAllAuthors();
    void showAuthor(int id);
    int countAll();
    void listPage(int number);
}
