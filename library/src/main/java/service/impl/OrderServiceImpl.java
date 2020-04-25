package service.impl;

import dao.DAOFactory;
import dao.OrderDAO;
import domain.Order;
import exception.ValidationException;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final OrderDAO dao = DAOFactory.getOrderDAO();

    @Override
    public boolean create(Order order) {
        checkOrder(order);
        return dao.create(order);
    }

    @Override
    public Order read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public boolean update(Order order) {
        checkOrder(order);
        return dao.update(order);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
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

        if (order.getReaderID() < 0) {
            throw new ValidationException("Invalid reader ID.");
        }
    }
}
