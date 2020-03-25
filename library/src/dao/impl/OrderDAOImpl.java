package dao.impl;

import dao.OrderDAO;
import domain.DataBase;
import domain.Order;

import java.io.IOException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public Order create(Order entity) {
        if (!DataBase.getAllOrders().isEmpty()) {
            entity.setId(DataBase.getAllOrders().get(DataBase.getAllOrders().size() - 1).getId() + 1);
        }
        else {
            entity.setId((long) 1);
        }
        DataBase.addOrder(entity);
        return entity;
    }

    @Override
    public Order read(long id) {
        for (Order order : DataBase.getAllOrders()) {
            if (order.getId().equals(id))
                return order;
        }
        return null;
    }

    @Override
    public List<Order> readAll() {
        return DataBase.getAllOrders();
    }

    @Override
    public void update(Order entity) throws IOException {
        for (Order order: DataBase.getAllOrders()) {
            if (order.getId().equals(entity.getId())) {
                order.setTakenBooks(entity.getTakenBooks());
            }
        }
        DataBase.writeAll();
    }

    @Override
    public void delete(Order entity) throws IOException {
        DataBase.getAllOrders().removeIf(order -> order.getId().equals(entity.getId()));
        DataBase.writeAll();
    }
}
