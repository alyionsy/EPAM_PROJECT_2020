package main.java.dao;

import java.io.IOException;
import java.util.List;

import main.java.domain.AbstractEntity;
import main.java.domain.Reader;

public interface GenericDAO<T extends AbstractEntity> {

    T create(T entity) throws IOException;

    T read(long id);

    List<T> readAll() throws IOException, ClassNotFoundException;

    Reader update(T entity) throws IOException;

    void delete(T entity) throws IOException;
}
