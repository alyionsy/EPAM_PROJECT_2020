package service;

import domain.Author;

import java.io.IOException;

public interface AuthorService {
    Author create(Author author) throws IOException;
    Author update(Author author) throws IOException;
    void delete(Author author) throws IOException;
    Author findByName(String name);
    Author read(long id);
    void listAllBooks() throws IOException, ClassNotFoundException;
}
