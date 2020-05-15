package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Librarian;

public interface LibrarianService {
    boolean create(Librarian librarian);
    Librarian read(int id);
    boolean update(Librarian librarian);
    boolean delete(int id);

    boolean findLibrarian(String username, String password);
}
