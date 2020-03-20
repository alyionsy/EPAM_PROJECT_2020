package dao;

import domain.BookOwner;
import domain.Order;

public interface OrderDAO extends GenericDAO<Order> {
    Order findOrderByOwner(BookOwner owner);
}
