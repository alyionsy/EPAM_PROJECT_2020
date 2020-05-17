package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.LibrarianDAO;
import by.mygeekacademy.library.dao.util.HibernateSessionFactoryUtil;
import by.mygeekacademy.library.domain.Librarian;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class LibrarianDAOImpl implements LibrarianDAO {
    private static final Logger logger = LogManager.getLogger(LibrarianDAOImpl.class.getName());

    @Override
    public void create(Librarian entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        logger.debug("Librarian created: " + entity);
        session.close();
    }

    @Override
    public Optional<Librarian> read(int id) {
        return Optional.of(HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Librarian.class, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Librarian> readAll() {
        return (List<Librarian>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Librarian").list();
    }

    @Override
    public void update(Librarian entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        logger.debug("Librarian updated: " + entity);
        session.close();
    }

    @Override
    public void delete(Librarian entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        logger.debug("Librarian deleted: " + entity);
        session.close();
    }

    @Override
    public boolean findLibrarian(String username, String password) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String query = String.format("SELECT COUNT(*) FROM Librarian WHERE username='%s' AND password='%s'",
                username, password);
        return ((int) (long) session.createQuery(query).uniqueResult()) > 0;
    }
}
