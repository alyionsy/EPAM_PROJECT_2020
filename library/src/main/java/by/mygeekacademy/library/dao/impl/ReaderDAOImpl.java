package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.ReaderDAO;
import by.mygeekacademy.library.domain.Reader;
import by.mygeekacademy.library.dao.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ReaderDAOImpl implements ReaderDAO {
    private static final Logger logger = LogManager.getLogger(ReaderDAOImpl.class.getName());

    @Override
    public void create(Reader entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        logger.debug("Reader created: " + entity);
        session.close();
    }

    @Override
    public Optional<Reader> read(int id) {
        return Optional.of(HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Reader.class, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reader> readAll() {
        return (List<Reader>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Reader").list();
    }

    @Override
    public void update(Reader entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        logger.debug("Reader updated: " + entity);
        session.close();
    }

    @Override
    public void delete(Reader entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        logger.debug("Reader deleted: " + entity);
        session.close();
    }
}
