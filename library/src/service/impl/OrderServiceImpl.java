package service.impl;

import dao.DAOFactory;
import dao.OrderDAO;
import domain.BookOwner;
import domain.Order;
import exception.ValidationException;
import service.OrderService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderServiceImpl implements OrderService {

    private static final OrderDAO dao = DAOFactory.getOrderDAO();

    @Override
    public Order create(Order order) throws IOException {
        if (order == null) {
            throw new ValidationException("Invalid order");
        }

        BookOwner owner = order.getOwner();
        if (owner == null) {
            throw new ValidationException("Owner is required");
        }

        return dao.create(order);
    }
}
