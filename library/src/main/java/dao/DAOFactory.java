package dao;

import dao.impl.AuthorDAOImpl;
import dao.impl.BookDAOImpl;
import dao.impl.ReaderDAOImpl;
import dao.impl.OrderDAOImpl;
import dao.util.DatabaseUtil;
import dao.util.DatabaseNames;

public final class DAOFactory {
    private static final DatabaseUtil sqlDatabaseConnection = new DatabaseUtil(DatabaseNames.MAIN_DATABASE);

    private static final BookDAO bookDAO = new BookDAOImpl(sqlDatabaseConnection);
    private static final ReaderDAO readerDAO = new ReaderDAOImpl(sqlDatabaseConnection);
    private static final OrderDAO orderDAO = new OrderDAOImpl(sqlDatabaseConnection);
    private static final AuthorDAO authorDAO = new AuthorDAOImpl(sqlDatabaseConnection);

    public static BookDAO getBookDAO() {
        return bookDAO;
    }
    public static ReaderDAO getReaderDAO() {
        return readerDAO;
    }
    public static OrderDAO getOrderDAO() {
        return orderDAO;
    }
    public static AuthorDAO getAuthorDAO() {
        return authorDAO;
    }
}
