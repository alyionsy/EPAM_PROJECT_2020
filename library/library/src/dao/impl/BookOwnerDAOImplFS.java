package dao.impl;

import dao.BookOwnerDAO;
import domain.BookOwner;
import domain.serializator.BookOwnerSerializator;

import java.util.List;

public class BookOwnerDAOImplFS implements BookOwnerDAO {

    public static final String FILE_NAME = "src/res/bookOwnerData.txt";

    @Override
    public BookOwner findByUsername(String username) {
        return null;
    }

    @Override
    public BookOwner create(BookOwner entity) {

    }

    @Override
    public BookOwner read(long id) {
        return null;
    }

    @Override
    public List<BookOwner> readAll() {
        return null;
    }

    @Override
    public void update(BookOwner entity) {

    }

    @Override
    public void delete(BookOwner entity) {

    }
}
