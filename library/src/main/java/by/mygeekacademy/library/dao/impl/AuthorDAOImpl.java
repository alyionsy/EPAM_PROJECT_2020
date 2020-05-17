package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.AuthorDAO;
import by.mygeekacademy.library.dao.util.HibernateSessionFactoryUtil;
import by.mygeekacademy.library.domain.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO {
    private static final Logger logger = LogManager.getLogger(AuthorDAOImpl.class.getName());
    private static final int PAGE_SIZE = 7;

    @Override
    public void create(Author entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        logger.debug("Author created: " + entity);
        session.close();
    }

    @Override
    public Optional<Author> read(int id) {
        return Optional.of(HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Author.class, id));
    }

    @Override
    public List<Author> readAll() {
        return (List<Author>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Author").list();
    }

    @Override
    public void update(Author entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        logger.debug("Author updated: " + entity);
        session.close();
    }

    @Override
    public void delete(Author entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        logger.debug("Author deleted: " + entity);
        session.close();
    }

    @Override
    public int countAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query countQuery = session.createQuery("SELECT COUNT(*) AS amount FROM Author");
        System.out.println();
        return (int) (long) countQuery.uniqueResult();
    }

    @Override
    public List<Author> readPage(int pageNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Author");
        query.setFirstResult((pageNumber - 1) * PAGE_SIZE);
        query.setMaxResults(PAGE_SIZE);
        return (List<Author>) query.list();
    }
}
