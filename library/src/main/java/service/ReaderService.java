package service;

import domain.Reader;

import java.io.IOException;

public interface ReaderService {
    Reader create(Reader owner) throws IOException;
    Reader update(Reader owner) throws IOException;
    void delete(Reader owner) throws IOException;
    Reader read(long id);
    void listAllReaders() throws IOException, ClassNotFoundException;
}
