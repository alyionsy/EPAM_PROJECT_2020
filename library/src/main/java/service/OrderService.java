package service;

import domain.Order;

import java.io.IOException;

public interface OrderService {
    Order create(Order order) throws IOException;
    Order update(Order order) throws IOException;
    void delete(Order order) throws IOException;
    Order read(long id);
    void listAllOrders() throws IOException, ClassNotFoundException;
}
