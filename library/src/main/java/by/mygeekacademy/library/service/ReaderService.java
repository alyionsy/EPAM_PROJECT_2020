package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Reader;

public interface ReaderService {
    boolean create(Reader owner);
    Reader read(int id);
    boolean update(Reader owner);
    boolean delete(int id);

    void listAllReaders();
    void showReader(int id);
}
