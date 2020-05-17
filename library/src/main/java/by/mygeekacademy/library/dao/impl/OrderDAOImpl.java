package by.mygeekacademy.library.dao.impl;

import by.mygeekacademy.library.dao.OrderDAO;
import by.mygeekacademy.library.domain.Order;
import by.mygeekacademy.library.dao.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class OrderDAOImpl implements OrderDAO {
    private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class.getName());

    @Override
    public List<Order> findByReaderID(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String query = String.format("FROM Order WHERE readID=%d", id);
        return session.createQuery(query, Order.class).getResultList();
    }

    @Override
    public List<Order> findByBookID(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String query = String.format("FROM Order WHERE bookID=%d", id);
        return session.createQuery(query, Order.class).getResultList();
    }

    @Override
    public void create(Order entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        logger.debug("Order created: " + entity);
        session.close();
    }

    @Override
    public Optional<Order> read(int id) {
        return Optional.of(HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Order.class, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> readAll() {
        return (List<Order>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Order").list();
    }

    @Override
    public void update(Order entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        logger.debug("Order updated: " + entity);
        session.close();
    }

    @Override
    public void delete(Order entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        logger.debug("Order deleted: " + entity);
        session.close();
    }
}
