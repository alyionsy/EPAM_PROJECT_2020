package dao;

import dao.impl.BookDAOImplFS;
import dao.impl.BookOwnerDAOImplFS;
import dao.impl.OrderDAOImplFS;

public final class DAOFactory {
    private static final BookDAO bookDAO = new BookDAOImplFS();
    private static final BookOwnerDAO bookOwnerDAO = new BookOwnerDAOImplFS();
    private static final OrderDAO orderDAO = new OrderDAOImplFS();

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
