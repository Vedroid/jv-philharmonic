package ua.vedroid.cinema.dao.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.vedroid.cinema.dao.ShoppingCartDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.lib.Dao;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.util.HibernateUtil;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private static final Logger log = LogManager.getLogger(ShoppingCartDaoImpl.class);

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            log.info("Added new shoppingCart: " + shoppingCart);
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert shoppingCart entity "
                    + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select sc from ShoppingCart sc "
                    + "left join fetch sc.tickets t "
                    + "left join fetch t.movieSession ms "
                    + "left join fetch ms.movie "
                    + "left join fetch ms.cinemaHall ", ShoppingCart.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all ShoppingCarts", e);
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ShoppingCart> shoppingCartQuery = session
                    .createQuery("select sc from ShoppingCart sc "
                            + "left join fetch sc.tickets t "
                            + "left join fetch t.movieSession ms "
                            + "left join fetch ms.movie "
                            + "left join fetch ms.cinemaHall "
                            + "where sc.user.id = :userId", ShoppingCart.class)
                    .setParameter("userId", user.getId());
            return shoppingCartQuery.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving ShoppingCarts by user "
                    + user, e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
            log.info("Updated shoppingCart: " + shoppingCart);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t updated shoppingCart entity "
                    + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
