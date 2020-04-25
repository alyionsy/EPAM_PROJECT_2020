package dao.impl;

import dao.AuthorDAO;
import dao.util.DatabaseUtil;
import domain.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    private Connection connection;
    private String database;
    private static final Logger logger = LogManager.getLogger(ReaderDAOImpl.class.getName());

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
                    "INSERT INTO %s.Authors (id, name, secondName)" +
                            " VALUES ('%d', '%s', '%s')",
                    database, entity.getId(), entity.getName(), entity.getSecondName()
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
    public Author read(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s.Authors WHERE id=%d", database, id);
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
    public List<Author> readAll() {
        try {
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM %s.Authors", database);
            ResultSet resultSet =  statement.executeQuery(query);

            ArrayList<Author> authors = new ArrayList<>();

            while(resultSet.next()) {
                authors.add(extractReaderFromResultSet(resultSet));
            }

            statement.close();
            return authors;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Author entity) {
        try {
            String query = String.format(
                    "UPDATE %s.Authors SET name='%s', secondName='%s' WHERE '%d'",
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
            String query = String.format("DELETE FROM %s.Authors WHERE id=%d", database, id);
            if (statement.executeUpdate(query) == 1) {
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
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
