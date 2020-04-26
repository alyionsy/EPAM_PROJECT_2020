package by.mygeekacademy.library.dao;

import java.util.LinkedList;
import java.util.Optional;

import by.mygeekacademy.library.domain.AbstractEntity;

public interface GenericDAO<T extends AbstractEntity> {
    boolean create(T entity);

    Optional<T> read(int id);

    LinkedList<T> readAll();

    boolean update(T entity);

    boolean delete(int id);
}
