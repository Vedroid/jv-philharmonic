package ua.vedroid.philharmonic.dao.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.vedroid.philharmonic.dao.OrderDao;
import ua.vedroid.philharmonic.exception.DataProcessingException;
import ua.vedroid.philharmonic.model.Order;
import ua.vedroid.philharmonic.model.User;

@Repository
public class OrderDaoImpl implements OrderDao {
    private static final Logger log = LogManager.getLogger(OrderDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            log.info("Added new order: " + order);
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert Order entity " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
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
