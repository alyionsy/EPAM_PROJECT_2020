package by.mygeekacademy.library.service.impl;

import by.mygeekacademy.library.dao.DAOFactory;
import by.mygeekacademy.library.dao.LibrarianDAO;
import by.mygeekacademy.library.domain.Librarian;
import by.mygeekacademy.library.service.LibrarianService;

public class LibrarianServiceImpl implements LibrarianService {
    private static final LibrarianDAO dao = DAOFactory.getLibrarianDAO();

    @Override
    public void create(Librarian librarian) {
        dao.create(librarian);
    }

    @Override
    public Librarian read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public void update(Librarian librarian) {
        dao.update(librarian);
    }

    @Override
    public void delete(Librarian librarian) {
        dao.delete(librarian);
    }

    @Override
    public boolean findLibrarian(String username, String password) {
        return dao.findLibrarian(username, password);
    }
}
