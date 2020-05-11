package by.mygeekacademy.library.dao;

import by.mygeekacademy.library.dao.impl.ReaderDAOImpl;
import by.mygeekacademy.library.dao.util.DatabaseName;
import by.mygeekacademy.library.dao.util.DatabaseUtil;
import by.mygeekacademy.library.domain.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestReaderDAO {
    private static final DatabaseUtil databaseConnection = new DatabaseUtil(DatabaseName.TEST_DATABASE);
    private static final ReaderDAO dao = new ReaderDAOImpl(databaseConnection);

    @Test
    public void createReaderTest() {
        Reader data = new Reader();
        data.setName("Andrzej");
        data.setSecondName("Sapkowski");
        Assertions.assertTrue(dao.create(data));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    public void readReaderTestPositive(int id) {
        Assertions.assertFalse(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void readReaderTestNegative(int id) {
        Assertions.assertTrue(dao.read(id).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5})
    public void updateReaderTest(int id) {
        Reader data = dao.read(id).get();
        data.setName("Test");
        data.setSecondName("Test");
        Assertions.assertTrue(dao.update(data));
    }

    @Test
    public void deleteReaderTestPositive() {
        Reader data = new Reader();
        data.setName("test");
        data.setSecondName("test");
        dao.create(data);
        int id = dao.readAll().getLast().getId();
        Assertions.assertTrue(dao.delete(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, Integer.MAX_VALUE, 0})
    public void deleteReaderTestNegative(int id) {
        Assertions.assertFalse(dao.delete(id));
    }
}
