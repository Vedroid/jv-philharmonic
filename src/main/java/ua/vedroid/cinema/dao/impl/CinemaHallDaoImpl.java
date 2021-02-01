package ua.vedroid.cinema.dao.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.vedroid.cinema.dao.CinemaHallDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.lib.Dao;
import ua.vedroid.cinema.model.CinemaHall;
import ua.vedroid.cinema.util.HibernateUtil;

@Dao
public class CinemaHallDaoImpl implements CinemaHallDao {
    static final Logger log = LogManager.getLogger(CinemaHallDaoImpl.class);

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            log.info("Added new cinemaHall: " + cinemaHall);
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can`t insert cinemaHall entity " + cinemaHall;
            log.error(msg, e);
            throw new DataProcessingException(msg, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CinemaHall> getAllCinemaHallQuery =
                    session.createQuery("from CinemaHall", CinemaHall.class);
            return getAllCinemaHallQuery.getResultList();
        } catch (Exception e) {
            String msg = "Error retrieving all CinemaHall";
            log.error(msg, e);
            throw new DataProcessingException(msg, e);
        }
    }
}
