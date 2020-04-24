package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domain.AbstractEntity;
import exception.NullValueException;

public interface GenericDAO<T extends AbstractEntity> {
    boolean create(T entity);

    T read(int id);

    List<T> readAll();

    boolean update(T entity);

    boolean delete(int id);
}
