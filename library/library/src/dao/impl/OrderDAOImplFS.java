package dao.impl;

import dao.OrderDAO;
import domain.BookOwner;
import domain.Order;
import domain.serializator.OrderSerializator;

import java.util.List;

public class OrderDAOImplFS implements OrderDAO {

    public static final String FILE_NAME = "src/res/orderData.txt";

    @Override
    public Order findOrderByOwner(BookOwner owner) {
        return null;
    }

    @Override
    public Order create(Order entity) {
        OrderSerializator sz = new OrderSerializator();
        boolean b = sz.serialization(entity, FILE_NAME);
        return entity;
    }

    @Override
    public Order read(long id) {
        return null;
    }

    @Override
    public List<Order> readAll() {
        return null;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }
}
