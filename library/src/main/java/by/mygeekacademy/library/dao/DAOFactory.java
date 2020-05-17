package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.dao.impl.*;

public final class DAOFactory {
    private static final BookDAO bookDAO = new BookDAOImpl();
    private static final ReaderDAO readerDAO = new ReaderDAOImpl();
    private static final OrderDAO orderDAO = new OrderDAOImpl();
    private static final AuthorDAO authorDAO = new AuthorDAOImpl();
    private static final LibrarianDAO librarianDAO = new LibrarianDAOImpl();

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
