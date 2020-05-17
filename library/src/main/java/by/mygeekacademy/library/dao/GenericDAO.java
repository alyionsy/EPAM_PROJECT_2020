package by.mygeekacademy.library.dao;

import java.util.List;
import java.util.Optional;

import by.mygeekacademy.library.domain.AbstractEntity;

public interface GenericDAO<T extends AbstractEntity> {
    void create(T entity);

    Optional<T> read(int id);

    List<T> readAll();

    void update(T entity);

    void delete(T entity);
}
