package by.mygeekacademy.library.service;

import by.mygeekacademy.library.domain.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);
    Order read(int id);
    void update(Order order);
    void delete(Order order);

    List<Order> findByReaderID(int id);
    List<Order> findByBookID(int id);
    void listAllOrders();
    void showOrder(int id);
}
