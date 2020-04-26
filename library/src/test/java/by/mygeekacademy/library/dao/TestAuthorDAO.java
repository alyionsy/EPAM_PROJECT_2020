package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.dao.impl.AuthorDAOImpl;
import by.mygeekacademy.library.dao.util.DatabaseNames;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.domain.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestAuthorDAO {
    private static final DatabaseUtil databaseConnection = new DatabaseUtil(DatabaseNames.TEST_DATABASE);
    private static final AuthorDAO dao = new AuthorDAOImpl(databaseConnection);

    @Test
    public void createAuthorTest() {
        Author data = new Author();
        data.setName("Andrzej");
        data.setSecondName("Sapkowski");
        Assertions.assertTrue(dao.create(data));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 19})
    public void readAuthorTestPositive(int id) {
        Assertions.assertFalse(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void readAuthorTestNegative(int id) {
        Assertions.assertTrue(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 16})
    public void updateAuthorTest(int id) {
        Author data = dao.read(id).get();
        data.setName("Test");
        data.setSecondName("Test");
        Assertions.assertTrue(dao.update(data));
    }

    @Test
    public void deleteAuthorTestPositive() {
        Author data = new Author();
        data.setName("test");
        data.setSecondName("test");
        dao.create(data);
        int id = dao.readAll().getLast().getId();
        Assertions.assertTrue(dao.delete(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void deleteAuthorTestNegative(int id) {
        Assertions.assertFalse(dao.delete(id));
    }
}
