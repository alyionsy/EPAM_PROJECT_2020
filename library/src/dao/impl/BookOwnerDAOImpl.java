package dao.impl;

import dao.BookOwnerDAO;
import domain.Book;
import domain.BookOwner;
import domain.DataBase;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookOwnerDAOImpl implements BookOwnerDAO {

    public static final int MAX_QUANTITY = 500;

    @Override
    public BookOwner create(BookOwner entity) {
        if (!DataBase.getAllOwners().isEmpty()) {
            entity.setId(DataBase.getAllOwners().get(DataBase.getAllOwners().size() - 1).getId() + 1);
        }
        else {
            entity.setId((long) 1);
        }
        DataBase.addBookOwner(entity);
        return entity;
    }

    @Override
    public BookOwner read(long id) {
        for (BookOwner owner : DataBase.getAllOwners()) {
            if (owner.getId().equals(id))
                return owner;
        }
        return null;
    }

    @Override
    public List<BookOwner> readAll() {
        return DataBase.getAllOwners();
    }

    @Override
    public void update(BookOwner entity) {
        for (BookOwner owner: DataBase.getAllOwners()) {
            if (owner.getId().equals(entity.getId())) {
                owner.setBookOwnerName(entity.getBookOwnerName());
                owner.setBookOwnerSecondName(entity.getBookOwnerSecondName());
            }
        }
    }

    @Override
    public void delete(BookOwner entity) {
        DataBase.getAllOwners().removeIf(owner -> owner.getId().equals(entity.getId()));
    }
}
