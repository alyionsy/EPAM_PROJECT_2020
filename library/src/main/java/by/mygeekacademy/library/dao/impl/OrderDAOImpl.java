package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.OrderDAO;
import by.mygeekacademy.library.domain.Order;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class.getName());

    public OrderDAOImpl(DatabaseUtil databaseUtil) {
        try {
            this.connection = databaseUtil.getConnection();
            this.database = databaseUtil.getDatabase();
        }
        catch (SQLException e){
            logger.error(e.toString());
        }
    }

    @Override
    public List<Order> findByReaderID(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Orders WHERE readID=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            List<Order> searchResult = new ArrayList<>();
            while (resultSet.next()) {
                searchResult.add(extractReaderFromResultSet(resultSet));
            }
            statement.close();
            logger.debug("Objects have been found");
            return searchResult;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been found");
        return null;
    }

    @Override
    public List<Order> findByBookID(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Orders WHERE bookID=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            List<Order> searchResult = new ArrayList<>();
            while (resultSet.next()) {
                searchResult.add(extractReaderFromResultSet(resultSet));
            }
            statement.close();
            logger.debug("Objects have been found");
            return searchResult;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been found");
        return null;
    }

    @Override
    public boolean create(Order entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Orders (readID, bookID)" +
                            " VALUES (%d, %d)",
                    database, entity.getReaderID(), entity.getBookID()
            );
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                logger.debug("Object has been created");
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        logger.debug("Object hasn't been found");
        return false;
    }

    @Override
    public Optional<Order> read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Orders WHERE id=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return Optional.of(extractReaderFromResultSet(resultSet));
            }
            statement.close();
            logger.debug("Object has been read");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Object hasn't been read");
        return Optional.empty();
    }

    @Override
    public LinkedList<Order> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Orders", database);
            ResultSet resultSet =  statement.executeQuery(query);

            LinkedList<Order> orders = new LinkedList<>();

            while(resultSet.next()) {
                orders.add(extractReaderFromResultSet(resultSet));
            }
            statement.close();
            logger.debug("Objects have been read");
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        logger.debug("Objects haven't been found");
        return null;
    }

    @Override
    public boolean update(Order entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Orders SET readID='%d', bookID='%d' WHERE id=%d",
                    database, entity.getReaderID(), entity.getBookID(), entity.getId()
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
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM %s.Orders WHERE id=%d", database, id);
            if (statement.executeUpdate(query) == 1) {
                statement.close();
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

    private Order extractReaderFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();

        order.setId(resultSet.getInt("id"));
        order.setReaderID(resultSet.getInt("readID"));
        order.setBookID(resultSet.getInt("bookID"));

        return order;
    }
}
