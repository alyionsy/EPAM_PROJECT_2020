package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.dao.impl.*;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.dao.util.DatabaseName;

public final class DAOFactory {
    private static final DatabaseUtil databaseConnection = new DatabaseUtil(DatabaseName.MAIN_DATABASE);

    private static final BookDAO bookDAO = new BookDAOImpl(databaseConnection);
    private static final ReaderDAO readerDAO = new ReaderDAOImpl(databaseConnection);
    private static final OrderDAO orderDAO = new OrderDAOImpl(databaseConnection);
    private static final AuthorDAO authorDAO = new AuthorDAOImpl(databaseConnection);
    private static final LibrarianDAO librarianDAO = new LibrarianDAOImpl(databaseConnection);

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
    public static LibrarianDAO getLibrarianDAO() {
        return librarianDAO;
    }
}
