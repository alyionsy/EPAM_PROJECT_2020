package dao.impl;

import dao.BookOwnerDAO;
import dao.DAOFactory;
import dao.OrderDAO;
import domain.Book;
import domain.BookOwner;
import domain.DataBase;
import domain.Order;

import java.io.IOException;
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
        for (Order order : DataBase.getAllOrders()) {
            if (entity.equals(order.getOwner())) {
                order.setOwner(entity);
            }
        }
    }

    @Override
    public void delete(BookOwner entity) throws IOException {
        DataBase.getAllOrders().removeIf(order -> order.getOwner().getId().equals(entity.getId()));
        DataBase.getAllOwners().removeIf(owner -> owner.getId().equals(entity.getId()));
        DataBase.writeAll();
    }
}
