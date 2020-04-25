package dao;

import domain.Order;

import java.util.List;

public interface OrderDAO extends GenericDAO<Order> {
    List<Order> findByReaderID(int id);
    List<Order> findByBookID(int id);
}
