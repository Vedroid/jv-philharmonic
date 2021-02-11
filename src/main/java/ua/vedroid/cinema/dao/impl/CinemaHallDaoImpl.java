package ua.vedroid.cinema.dao.impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.vedroid.cinema.dao.CinemaHallDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.model.CinemaHall;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    private static final Logger log = LogManager.getLogger(CinemaHallDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            log.info("Added new cinemaHall: " + cinemaHall);
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert CinemaHall entity " + cinemaHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from CinemaHall", CinemaHall.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all CinemaHall", e);
        }
    }

    @Override
    public Optional<CinemaHall> getById(Long cinemaHallId) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session
                    .createQuery("from CinemaHall where id = :id", CinemaHall.class)
                    .setParameter("id", cinemaHallId)
                    .getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving CinemaHall where id="
                    + cinemaHallId, e);
        }
    }
}
