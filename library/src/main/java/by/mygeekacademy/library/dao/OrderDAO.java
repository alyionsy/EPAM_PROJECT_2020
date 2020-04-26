package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.domain.Order;

import java.util.List;

public interface OrderDAO extends GenericDAO<Order> {
    List<Order> findByReaderID(int id);
    List<Order> findByBookID(int id);
}
