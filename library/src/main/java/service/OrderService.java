package service;

import domain.Order;

public interface OrderService {
    boolean create(Order order);
    Order read(int id);
    boolean update(Order order);
    boolean delete(int id);

    Order findByReaderID(int id);
    Order findByBookID(int id);
    void listAllOrders();
    void showOrder(int id);
}
