package service;

import domain.Reader;

public interface ReaderService {
    boolean create(Reader owner);
    Reader read(int id);
    boolean update(Reader owner);
    boolean delete(int id);

    void listAllReaders();
    void showReader(int id);
}
