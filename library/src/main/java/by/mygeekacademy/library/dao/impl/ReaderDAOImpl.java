package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.ReaderDAO;
import by.mygeekacademy.library.domain.Reader;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.Optional;

public class ReaderDAOImpl implements ReaderDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(ReaderDAOImpl.class.getName());

    public ReaderDAOImpl(DatabaseUtil databaseUtil) {
        try {
            this.connection = databaseUtil.getConnection();
            this.database = databaseUtil.getDatabase();
        }
        catch (SQLException e){
            logger.error(e.toString());
        }
    }

    @Override
    public boolean create(Reader entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Readers (name, secondName)" +
                            " VALUES ('%s', '%s')",
                    database, entity.getName(), entity.getSecondName()
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
    public Optional<Reader> read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Readers WHERE id=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return Optional.of(extractReaderFromResultSet(resultSet));
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public LinkedList<Reader> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Readers", database);
            ResultSet resultSet =  statement.executeQuery(query);

            LinkedList<Reader> readers = new LinkedList<>();

            while(resultSet.next()) {
                readers.add(extractReaderFromResultSet(resultSet));
            }
            statement.close();
            return readers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Reader entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Readers SET name='%s', secondName='%s' WHERE id=%d",
                    database, entity.getName(), entity.getSecondName(), entity.getId()
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
            String query = String.format("DELETE FROM %s.Readers WHERE id=%d", database, id);
            if (statement.executeUpdate(query) == 1) {
                statement.close();
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }

    private Reader extractReaderFromResultSet(ResultSet resultSet) throws SQLException {
        Reader reader = new Reader();

        reader.setId(resultSet.getInt("id"));
        reader.setName(resultSet.getString("name"));
        reader.setSecondName(resultSet.getString("secondName"));

        return reader;
    }
}
