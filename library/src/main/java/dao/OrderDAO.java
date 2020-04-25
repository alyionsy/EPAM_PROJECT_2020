package dao;

import domain.Order;

public interface OrderDAO extends GenericDAO<Order> {
    Order findByReaderID(int id);
    Order findByBookID(int id);
}
