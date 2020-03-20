package service.impl;

import dao.BookOwnerDAO;
import dao.DAOFactory;
import domain.BookOwner;
import exception.ValidationException;
import service.BookOwnerService;

public class BookOwnerServiceImpl implements BookOwnerService {

    private static final BookOwnerDAO dao = DAOFactory.getBookOwnerDAO();
    @Override
    public BookOwner create(BookOwner bookOwner) {
        if (bookOwner == null) {
            throw new ValidationException("Invalid book owner");
        }

        String username = bookOwner.getUsername();
        if (username == null || username.isEmpty()) {
            throw new ValidationException("Username is required");
        }

        String password = bookOwner.getPassword();
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password is required");
        }

        String bookOwnerName = bookOwner.getBookOwnerName();
        if (bookOwnerName == null || bookOwnerName.isEmpty()) {
            throw new ValidationException("Book owner's name is required");
        }

        String getBookOwnerSecondName = bookOwner.getBookOwnerSecondName();
        if (getBookOwnerSecondName == null || getBookOwnerSecondName.isEmpty()) {
            throw new ValidationException("Book owner's 2nd name is required");
        }

        return dao.create(bookOwner);
    }
}
