package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.LibrarianDAO;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.domain.Librarian;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Optional;

public class LibrarianDAOImpl implements LibrarianDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(LibrarianDAOImpl.class.getName());

    public LibrarianDAOImpl(DatabaseUtil databaseUtil) {
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
    public boolean create(Librarian entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Librarians (username, password)" +
                            " VALUES ('%s', '%s')",
                    database, entity.getUsername(), entity.getPassword()
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
    public Optional<Librarian> read(int id) {
        try {
            String query = String.format("SELECT * FROM %s.Librarians WHERE id=%d", database, id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(extractLibrarianFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public LinkedList<Librarian> readAll() {
        try {
            String query = String.format("SELECT * FROM %s.Readers", database);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            LinkedList<Librarian> librarians = new LinkedList<>();

            while(resultSet.next()) {
                librarians.add(extractLibrarianFromResultSet(resultSet));
            }
            return librarians;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Librarian entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Librarians SET username='%s', password='%s' WHERE id=%d",
                    database, entity.getUsername(), entity.getPassword(), entity.getId()
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
            String query = String.format("DELETE FROM %s.Librarians WHERE id=%d", database, id);
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

    private Librarian extractLibrarianFromResultSet(ResultSet resultSet) throws SQLException {
        Librarian librarian = new Librarian();

        librarian.setId(resultSet.getInt("id"));
        librarian.setUsername(resultSet.getString("username"));
        librarian.setUsername(resultSet.getString("password"));

        return librarian;
    }

    @Override
    public boolean findLibrarian(String username, String password) {
        try {
            String query = String.format("SELECT COUNT(*) AS amount FROM %s.Librarians WHERE username='%s' AND password='%s'",
                    database, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt("amount") == 1) {
                    return true;
                }
                logger.debug("Invalid librarian.");
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }
}
