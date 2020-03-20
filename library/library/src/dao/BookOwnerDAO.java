package dao;

import domain.BookOwner;

public interface BookOwnerDAO extends GenericDAO<BookOwner> {
    BookOwner findByUsername(String username);
}
