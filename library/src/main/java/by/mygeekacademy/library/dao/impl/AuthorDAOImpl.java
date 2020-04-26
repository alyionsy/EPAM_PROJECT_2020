package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.AuthorDAO;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.domain.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(AuthorDAOImpl.class.getName());

    public AuthorDAOImpl(DatabaseUtil databaseUtil) {
        try {
            this.connection = databaseUtil.getConnection();
            this.database = databaseUtil.getDatabase();
        }
        catch (SQLException e){
            logger.error(e.toString());
        }
    }

    @Override
    public boolean create(Author entity) {
        try {
            String query = String.format(
                    "INSERT INTO %s.Authors (name, secondName)" +
                            " VALUES ('%s', '%s')",
                    database, entity.getName(), entity.getSecondName()
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
    public Optional<Author> read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Authors WHERE id=%d", database, id);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                logger.debug("Object has been read successful");
                return Optional.of(extractReaderFromResultSet(resultSet));
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Object has been read as empty one");
        return Optional.empty();
    }

    @Override
    public LinkedList<Author> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Authors", database);
            ResultSet resultSet =  statement.executeQuery(query);

            LinkedList<Author> authors = new LinkedList<>();

            while(resultSet.next()) {
                authors.add(extractReaderFromResultSet(resultSet));
            }
            statement.close();
            logger.debug("Objects have been read successful");
            return authors;
        } catch (SQLException e) {
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Objects have been read as empty one");
        return null;
    }

    @Override
    public boolean update(Author entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Authors SET name='%s', secondName='%s' WHERE id=%d",
                    database, entity.getName(), entity.getSecondName(), entity.getId()
            );
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeUpdate() == 1) {
                logger.debug("Objects has been updated successful");
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Objects hasn't been updated");
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM %s.Authors WHERE id=%d", database, id);
            if (statement.executeUpdate(query) == 1) {
                statement.close();
                logger.debug("Objects has been deleted successful");
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
            logger.error(e.toString());
        }
        logger.debug("Objects hasn't been deleted");
        return false;
    }

    private Author extractReaderFromResultSet(ResultSet resultSet) throws SQLException {
        Author author = new Author();

        author.setId(resultSet.getInt("id"));
        author.setName(resultSet.getString("name"));
        author.setSecondName(resultSet.getString("secondName"));

        return author;
    }
}
