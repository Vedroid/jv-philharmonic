package ua.vedroid.cinema.dao.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ua.vedroid.cinema.dao.OrderDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.util.HibernateUtil;

@Repository
public class OrderDaoImpl implements OrderDao {
    private static final Logger log = LogManager.getLogger(OrderDaoImpl.class);

    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            log.info("Added new order: " + order);
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert order entity " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Order o "
                    + "left join fetch o.tickets t "
                    + "left join fetch t.movieSession ms "
                    + "left join fetch ms.movie "
                    + "left join fetch ms.cinemaHall", Order.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all Orders", e);
        }
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select distinct o from Order o "
                    + "left join fetch o.tickets t "
                    + "left join fetch t.movieSession ms "
                    + "left join fetch ms.movie "
                    + "left join fetch ms.cinemaHall "
                    + "where o.user.id = :userId", Order.class)
                    .setParameter("userId", user.getId())
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all Orders by User " + user, e);
        }
    }
}
