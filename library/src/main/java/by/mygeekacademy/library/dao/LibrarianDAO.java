package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.domain.Librarian;

public interface LibrarianDAO extends GenericDAO<Librarian> {
    boolean findLibrarian(String username, String password);
}
