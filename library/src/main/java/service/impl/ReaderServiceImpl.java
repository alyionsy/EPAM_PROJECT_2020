package main.java.service.impl;

import main.java.dao.ReaderDAO;
import main.java.dao.DAOFactory;
import main.java.domain.Reader;
import main.java.exception.ValidationException;
import main.java.service.ReaderService;

import java.io.IOException;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    private static final ReaderDAO dao = DAOFactory.getReaderDAO();
    @Override
    public Reader create(Reader reader) throws IOException {
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

        return dao.create(reader);
    }

    @Override
    public Reader update(Reader reader) throws IOException {
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

        return dao.update(reader);
    }

    @Override
    public void delete(Reader reader) throws IOException {
        if (reader == null) {
            throw new ValidationException("Invalid reader");
        }

        dao.delete(reader);
    }

    @Override
    public Reader read(long id) {
        return dao.read(id);
    }

    @Override
    public void listAllReaders() throws IOException, ClassNotFoundException {
        List<Reader> allReaders = dao.readAll();
        for (Reader reader : allReaders) {
            System.out.println(reader + "\n");
        }
    }
}
