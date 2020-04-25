package dao.impl;

import dao.BookDAO;
import dao.util.DatabaseUtil;
import domain.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(ReaderDAOImpl.class.getName());

    public BookDAOImpl(DatabaseUtil databaseUtil) {
        try {
            this.connection = databaseUtil.getConnection();
            this.database = databaseUtil.getDatabase();
        }
        catch (SQLException e){
            logger.error(e.toString());
        }
    }

    @Override
    public Book findByYear(int year) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Books WHERE year=%d", database, year);
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
    public Book findByName(String name) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Books WHERE name=%s", database, name);
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
    public Book findByAuthorID(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Books WHERE authorID=%d", database, id);
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
    public boolean create(Book entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Books (id, name, authorID, year, description)" +
                            " VALUES ('%d', '%s', '%d', '%d', '%s')",
                    database, entity.getId(), entity.getName(), entity.getAuthorID(), entity.getYear(), entity.getDescription()
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
    public Book read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Books WHERE id=%d", database, id);
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
    public List<Book> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Books", database);
            ResultSet resultSet =  statement.executeQuery(query);

            ArrayList<Book> books = new ArrayList<>();

            while(resultSet.next()) {
                books.add(extractReaderFromResultSet(resultSet));
            }

            statement.close();
            return books;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Book entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Readers SET name='%s', authorID='%d', year='%d', description='%s' WHERE '%d'",
                    database, entity.getName(), entity.getAuthorID(), entity.getYear(), entity.getDescription(), entity.getId()
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
            String query = String.format("DELETE FROM %s.Books WHERE id=%d", database, id);
            if (statement.executeUpdate(query) == 1) {
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
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
