package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Order;

import java.util.List;

public interface OrderService {
    boolean create(Order order);
    Order read(int id);
    boolean update(Order order);
    boolean delete(int id);

    List<Order> findByReaderID(int id);
    List<Order> findByBookID(int id);
    void listAllOrders();
    void showOrder(int id);
}
