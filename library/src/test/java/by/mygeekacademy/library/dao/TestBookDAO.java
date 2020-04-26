package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.dao.impl.BookDAOImpl;
import by.mygeekacademy.library.dao.util.DatabaseNames;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestBookDAO {
    private static final DatabaseUtil databaseConnection = new DatabaseUtil(DatabaseNames.TEST_DATABASE);
    private static final BookDAO dao = new BookDAOImpl(databaseConnection);

    @Test
    public void createBookTestPositive() {
        Book data = new Book();
        data.setName("Moonborn");
        data.setAuthorID(4);
        data.setYear(1999);
        data.setDescription("nice");
        Assertions.assertTrue(dao.create(data));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 19})
    public void readBookTestPositive(int id) {
        Assertions.assertFalse(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, 25, 0})
    public void readBookTestNegative(int id) {
        Assertions.assertTrue(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 16})
    public void updateBookTest(int id) {
        Book data = dao.read(id).get();
        data.setName("Test");
        data.setAuthorID(1);
        data.setYear(2000);
        data.setDescription("really bad");
        Assertions.assertTrue(dao.update(data));
    }

    @Test
    public void deleteBookTestPositive() {
        Book data = new Book();
        data.setName("test");
        data.setAuthorID(4);
        data.setYear(1999);
        data.setDescription("test");
        dao.create(data);
        int id = dao.readAll().getLast().getId();
        Assertions.assertTrue(dao.delete(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void deleteBookTestNegative(int id) {
        Assertions.assertFalse(dao.delete(id));
    }

    @Test
    public void findByYearBookTestPositive() {
        int year = 2000;
        int expected = 5;
        int real = dao.findByYear(year).size();
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void findByAuthorIDBookTestPositive() {
        int id = 1;
        int expected = 5;
        int real = dao.findByAuthorID(id).size();
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void findByNameBookTestPositive() {
        String name = "test";
        int expected = 4;
        int real = dao.findByName(name).size();
        Assertions.assertEquals(expected, real);
    }
}
