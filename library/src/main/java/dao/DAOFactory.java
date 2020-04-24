package main.java.dao;

import main.java.dao.impl.BookDAOImpl;
import main.java.dao.impl.ReaderDAOImpl;
import main.java.dao.impl.OrderDAOImpl;

public final class DAOFactory {
    private static final BookDAO bookDAO = new BookDAOImpl();
    private static final ReaderDAO readerDAO = new ReaderDAOImpl();
    private static final OrderDAO orderDAO = new OrderDAOImpl();

    public static BookDAO getBookDAO() {
        return bookDAO;
    }
    public static ReaderDAO getReaderDAO() {
        return readerDAO;
    }
    public static OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
