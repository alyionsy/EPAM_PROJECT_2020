package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.BookDAO;
import by.mygeekacademy.library.domain.Book;
import by.mygeekacademy.library.dao.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {
    private static final Logger logger = LogManager.getLogger(BookDAOImpl.class.getName());
    private static final int PAGE_SIZE = 5;

    @Override
    public List<Book> findByYear(int year) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String query = String.format("FROM Book WHERE year=%d", year);
        return session.createQuery(query, Book.class).getResultList();
    }

    @Override
    public List<Book> findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String query = String.format("FROM Book WHERE name='%s'", name);
        return session.createQuery(query, Book.class).getResultList();
    }

    @Override
    public List<Book> findByAuthorID(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String query = "FROM Book WHERE authorID=" + id;
        return session.createQuery(query, Book.class).getResultList();
    }

    @Override
    public int countAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query countQuery = session.createQuery("SELECT COUNT(*) AS amount FROM Book");
        return (int) (long) countQuery.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> readPage(int pageNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Book");
        query.setFirstResult((pageNumber - 1) * PAGE_SIZE);
        query.setMaxResults(PAGE_SIZE);
        return (List<Book>) query.list();
    }

    @Override
    public void create(Book entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        logger.debug("Book created: " + entity);
        session.close();
    }

    @Override
    public Optional<Book> read(int id) {
        return Optional.of(HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> readAll() {
        return (List<Book>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Book").list();
    }

    @Override
    public void update(Book entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        logger.debug("Book updated: " + entity);
        session.close();
    }

    @Override
    public void delete(Book entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        logger.debug("Book deleted: " + entity);
        session.close();
    }

}
