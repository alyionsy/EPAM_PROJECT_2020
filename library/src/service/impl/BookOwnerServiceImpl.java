package service.impl;

import dao.BookOwnerDAO;
import dao.DAOFactory;
import domain.Book;
import domain.BookOwner;
import exception.ValidationException;
import service.BookOwnerService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BookOwnerServiceImpl implements BookOwnerService {

    private static final BookOwnerDAO dao = DAOFactory.getBookOwnerDAO();
    @Override
    public BookOwner create(BookOwner owner) throws IOException {
        if (owner == null) {
            throw new ValidationException("Invalid book owner");
        }

        String bookOwnerName = owner.getBookOwnerName();
        if (bookOwnerName == null || bookOwnerName.isEmpty()) {
            throw new ValidationException("Book owner's name is required");
        }

        String bookOwnerSecondName = owner.getBookOwnerSecondName();
        if (bookOwnerSecondName == null || bookOwnerSecondName.isEmpty()) {
            throw new ValidationException("Book owner's 2nd name is required");
        }

        return dao.create(owner);
    }

    @Override
    public BookOwner update(BookOwner owner) {
        return null;
    }

    @Override
    public void delete(BookOwner owner) throws IOException {
        if (owner == null) {
            throw new ValidationException("Invalid owner");
        }

        dao.delete(owner);
    }

    @Override
    public BookOwner read(long id) {
        return dao.read(id);
    }

    @Override
    public void listAllOwners() throws IOException, ClassNotFoundException {
        List<BookOwner> allOwners = dao.readAll();
        for (BookOwner owners : allOwners) {
            System.out.println(owners + "\n");
        }
        System.out.println(allOwners.size() + "\n");
    }
}
