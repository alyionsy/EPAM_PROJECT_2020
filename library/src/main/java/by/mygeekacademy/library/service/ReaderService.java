package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Reader;

import java.util.List;

public interface ReaderService {
    void create(Reader reader);
    Reader read(int id);
    List<Reader> readAll();
    void update(Reader reader);
    void delete(Reader reader);

    void listAllReaders();
    void showReader(int id);
}
