package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.BookDAO;
import by.mygeekacademy.library.domain.Book;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(BookDAOImpl.class.getName());

    public BookDAOImpl(DatabaseUtil databaseUtil) {
        try {
            this.connection = databaseUtil.getConnection();
            this.database = databaseUtil.getDatabase();
        }
        catch (SQLException e){
            logger.error(e.toString());
            DatabaseUtil.connectionFailed();
        }
    }

    @Override
    public List<Book> findByYear(int year) {
        try {
            String query = String.format("SELECT * FROM %s.Books WHERE year=%d", database, year);
            return getBooks(query);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been found");
        return null;
    }

    @Override
    public List<Book> findByName(String name) {
        try {
            String query = String.format("SELECT * FROM %s.Books WHERE name='%s'", database, name);
            return getBooks(query);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been found");
        return null;
    }

    @Override
    public List<Book> findByAuthorID(int id) {
        try {
            String query = String.format("SELECT * FROM %s.Books WHERE authorID=%d", database, id);
            return getBooks(query);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been found");
        return null;
    }

    private LinkedList<Book> getBooks(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        LinkedList<Book> searchResult = new LinkedList<>();
        while(resultSet.next()) {
            searchResult.add(extractReaderFromResultSet(resultSet));
        }
        return searchResult;
    }

    @Override
    public int countAll() {
        int result = -1;
        try {
            String query = String.format("SELECT COUNT(*) AS amount FROM %s.Authors", database);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("amount");
                logger.debug("Amount of authors: " + result);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public LinkedList<Book> readPage(int start) {
        try {
            String query = String.format(
                    "DECLARE @StartRow int = %d, @RowsPerPage int = 5;" +
                            "\nSELECT * FROM %s.Books" +
                            "\nORDER BY id ASC" +
                            "\nOFFSET @StartRow - 1" +
                            "\nROWS FETCH NEXT @RowsPerPage ROWS ONLY;", start, database);
            return getBooks(query);
        } catch (SQLException e) {
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Objects have been read as empty one");
        return null;
    }

    @Override
    public boolean create(Book entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Books (name, authorID, year, description)" +
                            " VALUES ('%s', %d, %d, '%s')",
                    database, entity.getName(), entity.getAuthorID(), entity.getYear(), entity.getDescription()
            );
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                logger.debug("Object has been created");
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Object hasn't been created");
        return false;
    }

    @Override
    public Optional<Book> read(int id) {
        try {
            String query = String.format("SELECT * FROM %s.Books WHERE id=%d", database, id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(extractReaderFromResultSet(resultSet));
            }
            logger.debug("Object has been read");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Object hasn't been read");
        return Optional.empty();
    }

    @Override
    public LinkedList<Book> readAll() {
        try {
            String query = String.format("SELECT * FROM %s.Books", database);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            LinkedList<Book> books = new LinkedList<>();
            while(resultSet.next()) {
                books.add(extractReaderFromResultSet(resultSet));
            }
            logger.debug("Objects have been read");
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been read");
        return null;
    }

    @Override
    public boolean update(Book entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Books SET name='%s', authorID=%d, year=%d, description='%s' WHERE id=%d",
                    database, entity.getName(), entity.getAuthorID(), entity.getYear(), entity.getDescription(), entity.getId()
            );
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                logger.debug("Object has been updated");
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Object hasn't been updated");
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            String query = String.format("DELETE FROM %s.Books WHERE id=%d", database, id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                logger.debug("Object has been deleted");
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Object hasn't been deleted");
        return false;
    }

    private Book extractReaderFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthorID(resultSet.getInt("authorID"));
        book.setYear(resultSet.getInt("year"));
        book.setDescription(resultSet.getString("description"));

        return book;
    }

}
