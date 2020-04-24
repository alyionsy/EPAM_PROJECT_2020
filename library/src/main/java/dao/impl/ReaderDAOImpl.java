package dao.impl;

import dao.ReaderDAO;
import dao.util.DBUtil;
import domain.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOImpl implements ReaderDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(ReaderDAOImpl.class.getName());

    public ReaderDAOImpl(DBUtil dbUtil) {
        try {
            this.connection = dbUtil.getConnection();
            this.database = dbUtil.getDatabase();
        }
        catch (SQLException e){
            logger.error(e.toString());
        }
    }

    @Override
    public boolean create(Reader entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Readers (id, name, secondName)" +
                            " VALUES ('%d', '%s', '%s')",
                    database, entity.getId(), entity.getReaderName(), entity.getReaderSecondName()
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
    public Reader read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Readers WHERE id=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
//                statement.close();
                return extractReaderFromResultSet(resultSet);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reader> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Readers", database);
            ResultSet resultSet =  statement.executeQuery(query);

            ArrayList<Reader> readers = new ArrayList<>();

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
                    "UPDATE %s.Readers SET name='%s', secondName='%s' WHERE '%d'",
                    database, entity.getReaderName(), entity.getReaderSecondName(), entity.getId()
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
        reader.setReaderName(resultSet.getString("name"));
        reader.setReaderSecondName(resultSet.getString("secondName"));

        return reader;
    }
}
