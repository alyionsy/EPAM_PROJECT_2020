package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Librarian;

import java.util.List;

public interface LibrarianService {
    void create(Librarian librarian);
    Librarian read(int id);
    List<Librarian> readAll();
    void update(Librarian librarian);
    void delete(Librarian librarian);

    boolean findLibrarian(String username, String password);
}
