package dao;

import dao.impl.BookDAOImpl;
import dao.impl.ReaderDAOImpl;
import dao.impl.OrderDAOImpl;
import dao.util.DBUtil;
import dao.util.DatabaseNames;

public final class DAOFactory {
    private static final DBUtil sqlDatabaseConnection = new DBUtil(DatabaseNames.MAIN_DATABASE);

    private static final BookDAO bookDAO = new BookDAOImpl();
    private static final ReaderDAO readerDAO = new ReaderDAOImpl(sqlDatabaseConnection);
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
