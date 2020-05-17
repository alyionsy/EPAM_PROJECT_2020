package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Author;

public interface AuthorService {
    void create(Author author);
    Author read(int id);
    void update(Author author);
    void delete(Author author);

    void listAllAuthors();
    void showAuthor(int id);
    int countAll();
    void listPage(int number);
}
