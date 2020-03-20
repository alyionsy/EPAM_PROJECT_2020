package dao;

import domain.BookOwner;

public interface BookOwnerDAO extends GenericDAO<BookOwner> {
    BookOwner findByNumber(String number);
}
