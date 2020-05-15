package by.mygeekacademy.library.service.impl;

import by.mygeekacademy.library.dao.DAOFactory;
import by.mygeekacademy.library.dao.LibrarianDAO;
import by.mygeekacademy.library.domain.Librarian;
import by.mygeekacademy.library.service.LibrarianService;

public class LibrarianServiceImpl implements LibrarianService {
    private static final LibrarianDAO dao = DAOFactory.getLibrarianDAO();

    @Override
    public boolean create(Librarian librarian) {
        return dao.create(librarian);
    }

    @Override
    public Librarian read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public boolean update(Librarian librarian) {
        return dao.update(librarian);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public boolean findLibrarian(String username, String password) {
        return dao.findLibrarian(username, password);
    }
}
