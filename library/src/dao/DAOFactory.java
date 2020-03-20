package dao;

import dao.impl.BookDAOImpl;
import dao.impl.BookOwnerDAOImpl;
import dao.impl.OrderDAOImpl;

public final class DAOFactory {
    private static final BookDAO bookDAO = new BookDAOImpl();
    private static final BookOwnerDAO bookOwnerDAO = new BookOwnerDAOImpl();
    private static final OrderDAO orderDAO = new OrderDAOImpl();

    public static BookDAO getBookDAO() {
        return bookDAO;
    }
    public static BookOwnerDAO getBookOwnerDAO() {
        return bookOwnerDAO;
    }
    public static OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
