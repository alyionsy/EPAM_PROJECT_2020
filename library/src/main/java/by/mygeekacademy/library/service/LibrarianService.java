package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Librarian;

public interface LibrarianService {
    void create(Librarian librarian);
    Librarian read(int id);
    void update(Librarian librarian);
    void delete(Librarian librarian);

    boolean findLibrarian(String username, String password);
}
