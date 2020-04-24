package main.java.dao.impl;

import main.java.dao.ReaderDAO;
import main.java.domain.Reader;
import main.java.domain.DataBase;
import main.java.domain.Order;

import java.util.List;

public class ReaderDAOImpl implements ReaderDAO {

    @Override
    public Reader create(Reader entity) {
        if (!DataBase.getAllReaders().isEmpty()) {
            entity.setId(DataBase.getAllReaders().get(DataBase.getAllReaders().size() - 1).getId() + 1);
        }
        else {
            entity.setId((long) 1);
        }
        DataBase.addReader(entity);
        DataBase.writeAll();
        return entity;
    }

    @Override
    public Reader read(long id) {
        for (Reader reader : DataBase.getAllReaders()) {
            if (reader.getId().equals(id))
                return reader;
        }
        return null;
    }

    @Override
    public List<Reader> readAll() {
        return DataBase.getAllReaders();
    }

    @Override
    public Reader update(Reader entity) {
        for (Reader reader: DataBase.getAllReaders()) {
            if (reader.getId().equals(entity.getId())) {
                reader.setReaderName(entity.getReaderName());
                reader.setReaderSecondName(entity.getReaderSecondName());
            }
        }
        for (Order order : DataBase.getAllOrders()) {
            if (entity.equals(order.getReader())) {
                order.setReader(entity);
            }
        }
        DataBase.writeAll();
        return entity;
    }

    @Override
    public void delete(Reader entity) {
        DataBase.getAllOrders().removeIf(order -> order.getReader().getId().equals(entity.getId()));
        DataBase.getAllReaders().removeIf(reader -> reader.getId().equals(entity.getId()));
        DataBase.writeAll();
    }
}
