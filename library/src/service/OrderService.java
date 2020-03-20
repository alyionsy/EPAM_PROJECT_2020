package service;

import domain.Order;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderService {
    Order create(Order order) throws IOException;
}
