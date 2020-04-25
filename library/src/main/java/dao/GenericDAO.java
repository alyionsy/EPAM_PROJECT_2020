package dao;

import java.util.List;

import domain.AbstractEntity;

public interface GenericDAO<T extends AbstractEntity> {
    boolean create(T entity);

    T read(int id);

    List<T> readAll();

    boolean update(T entity);

    boolean delete(int id);
}
