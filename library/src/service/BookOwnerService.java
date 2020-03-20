package service;

import domain.BookOwner;

public interface BookOwnerService {
    BookOwner create(BookOwner owner);
    BookOwner update(BookOwner owner);
    void delete(BookOwner owner);
    BookOwner findByNumber(String number);
}
