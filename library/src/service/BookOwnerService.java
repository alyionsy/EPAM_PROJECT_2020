package service;

import domain.BookOwner;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BookOwnerService {
    BookOwner create(BookOwner owner) throws IOException;
    BookOwner update(BookOwner owner);
    void delete(BookOwner owner) throws IOException;
    BookOwner read(long id);
    void listAllOwners() throws IOException, ClassNotFoundException;
}
