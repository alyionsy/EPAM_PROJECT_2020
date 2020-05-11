package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.dao.impl.OrderDAOImpl;
import by.mygeekacademy.library.dao.util.DatabaseName;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestOrderDAO {
    private static final DatabaseUtil databaseConnection = new DatabaseUtil(DatabaseName.TEST_DATABASE);
    private static final OrderDAO dao = new OrderDAOImpl(databaseConnection);

    @Test
    public void createOrderTest() {
        Order data = new Order();
        data.setReaderID(2);
        data.setBookID(2);
        Assertions.assertTrue(dao.create(data));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    public void readOrderTestPositive(int id) {
        Assertions.assertFalse(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void readOrderTestNegative(int id) {
        Assertions.assertTrue(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5})
    public void updateOrderTest(int id) {
        Order data = dao.read(id).get();
        data.setReaderID(1);
        data.setBookID(1);
        Assertions.assertTrue(dao.update(data));
    }

    @Test
    public void deleteOrderTestPositive() {
        Order data = new Order();
        data.setReaderID(1);
        data.setBookID(1);
        dao.create(data);
        int id = dao.readAll().getLast().getId();
        Assertions.assertTrue(dao.delete(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void deleteOrderTestNegative(int id) {
        Assertions.assertFalse(dao.delete(id));
    }

    @Test
    public void findByReaderIDOrderTest() {
        int id = 1;
        int expected = 6;
        int real = dao.findByReaderID(id).size();
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void findByBookIDOrderTest() {
        int id = 1;
        int expected = 6;
        int real = dao.findByBookID(id).size();
        Assertions.assertEquals(expected, real);
    }
}
