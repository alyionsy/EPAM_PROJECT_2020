package by.mygeekacademy.library.service.impl;

import by.mygeekacademy.library.dao.DAOFactory;
import by.mygeekacademy.library.dao.OrderDAO;
import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.domain.Order;
import by.mygeekacademy.library.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final OrderDAO dao = DAOFactory.getOrderDAO();

    @Override
    public void create(Order order) {
        checkOrder(order);
        dao.create(order);
    }

    @Override
    public Order read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public void update(Order order) {
        checkOrder(order);
        dao.update(order);
    }

    @Override
    public void delete(Order order) {
        dao.delete(order);
    }

    @Override
    public List<Order> findByReaderID(int id) {
        return dao.findByReaderID(id);
    }

    @Override
    public List<Order> findByBookID(int id) {
        return dao.findByBookID(id);
    }

    @Override
    public void listAllOrders() {
        List<Order> allOrders = dao.readAll();
        for (Order order : allOrders) {
            System.out.println(order + "\n");
        }
    }

    @Override
    public void showOrder(int id) {
        if (dao.read(id).isEmpty()) {
            System.out.println("No such elements");
        } else {
            System.out.println(dao.read(id).get());
        }
    }

    private void checkOrder(Order order) {
        if (order == null) {
            throw new ValidationException("Invalid order.");
        }

        if (order.getBookID() < 0) {
            throw new ValidationException("Invalid book ID.");
        }

        if (order.getReadID() < 0) {
            throw new ValidationException("Invalid reader ID.");
        }
    }
}
