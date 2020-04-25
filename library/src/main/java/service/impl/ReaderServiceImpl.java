package service.impl;

import dao.ReaderDAO;
import dao.DAOFactory;
import domain.Reader;
import exception.ValidationException;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    private static final ReaderDAO dao = DAOFactory.getReaderDAO();

    @Override
    public boolean create(Reader reader) {
        checkReader(reader);
        return dao.create(reader);
    }

    @Override
    public Reader read(int id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public boolean update(Reader reader) {
        checkReader(reader);
        return dao.update(reader);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public void listAllReaders() {
        List<Reader> allReaders = dao.readAll();
        for (Reader reader : allReaders) {
            System.out.println(reader + "\n");
        }
    }

    @Override
    public void showReader(int id) {
        if (dao.read(id).isEmpty()) {
            System.out.println("No such elements");
        } else {
            System.out.println(dao.read(id).get());
        }
    }

    private void checkReader(Reader reader) {
        if (reader == null) {
            throw new ValidationException("Invalid reader");
        }

        String readerName = reader.getReaderName();
        if (readerName == null || readerName.isEmpty()) {
            throw new ValidationException("Reader's name is required");
        }

        String readerSecondName = reader.getReaderSecondName();
        if (readerSecondName == null || readerSecondName.isEmpty()) {
            throw new ValidationException("Reader's 2nd name is required");
        }
    }
}
