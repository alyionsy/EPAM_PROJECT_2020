package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Reader;

public interface ReaderService {
    void create(Reader reader);
    Reader read(int id);
    void update(Reader reader);
    void delete(Reader reader);

    void listAllReaders();
    void showReader(int id);
}
