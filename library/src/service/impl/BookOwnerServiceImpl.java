package service.impl;

import dao.BookOwnerDAO;
import dao.DAOFactory;
import domain.BookOwner;
import exception.ValidationException;
import service.BookOwnerService;

public class BookOwnerServiceImpl implements BookOwnerService {

    private static final BookOwnerDAO dao = DAOFactory.getBookOwnerDAO();
    @Override
    public BookOwner create(BookOwner owner) {
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

        String bookOwnerNumber = owner.getBookOwnerNumber();
        if (bookOwnerNumber == null || bookOwnerNumber.isEmpty()) {
            throw new ValidationException("Book owner's reading number is required");
        }

        if (bookOwnerNumber.length() > 6 || bookOwnerNumber.length() < 1) {
            throw new ValidationException("Book owner's number is in wrong format." +
                    "It must be longer than 1 symbol and shorter than 6 symbols");
        }

        return dao.create(owner);
    }

    @Override
    public BookOwner update(BookOwner owner) {
        return null;
    }

    @Override
    public void delete(BookOwner owner) {
        if (owner == null) {
            throw new ValidationException("Invalid owner");
        }

        dao.delete(owner);
    }

    @Override
    public BookOwner findByNumber(String number) {
        return dao.findByNumber(number);
    }
}
