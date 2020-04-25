package dao.impl;

import dao.OrderDAO;
import dao.util.DatabaseUtil;
import domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(ReaderDAOImpl.class.getName());

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
    public Order findByReaderID(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Orders WHERE readerID=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                statement.close();
                return extractReaderFromResultSet(resultSet);
            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Order findByBookID(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Orders WHERE bookID=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                statement.close();
                return extractReaderFromResultSet(resultSet);
            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Order entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Orders (id, readerID, bookID)" +
                            " VALUES ('%d', '%d', '%d')",
                    database, entity.getId(), entity.getReaderID(), entity.getBookID()
            );
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }

        return false;
    }

    @Override
    public Order read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Orders WHERE id=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                statement.close();
                return extractReaderFromResultSet(resultSet);
            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Order", database);
            ResultSet resultSet =  statement.executeQuery(query);

            ArrayList<Order> orders = new ArrayList<>();

            while(resultSet.next()) {
                orders.add(extractReaderFromResultSet(resultSet));
            }

            statement.close();
            return orders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Order entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Orders SET readerID='%d', bookID='%d' WHERE '%d'",
                    database, entity.getReaderID(), entity.getBookID(), entity.getId()
            );
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM %s.Orders WHERE id=%d", database, id);
            if (statement.executeUpdate(query) == 1) {
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }

    private Order extractReaderFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();

        order.setId(resultSet.getInt("id"));
        order.setReaderID(resultSet.getInt("readerID"));
        order.setBookID(resultSet.getInt("bookID"));

        return order;
    }
}
