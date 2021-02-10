package ua.vedroid.cinema.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.vedroid.cinema.dao.MovieSessionDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.util.HibernateUtil;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    private static final Logger log = LogManager.getLogger(MovieSessionDaoImpl.class);

    @Override
    public MovieSession add(MovieSession movieSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            log.info("Added new movieSession: " + movieSession);
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert movieSession entity "
                    + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<MovieSession> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getAllMovieSessionQuery =
                    session.createQuery("from MovieSession ms "
                            + "left join fetch ms.cinemaHall "
                            + "left join fetch ms.movie", MovieSession.class);
            return getAllMovieSessionQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all MovieSession", e);
        }
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getAvailableMovieSessionQuery =
                    session.createQuery("from MovieSession ms "
                            + "left join fetch ms.cinemaHall "
                            + "left join fetch ms.movie "
                            + "where ms.movie.id = :id "
                            + "and to_char(ms.showTime, 'YYYY-MM-DD') = :date", MovieSession.class);
            getAvailableMovieSessionQuery.setParameter("id", movieId);
            getAvailableMovieSessionQuery.setParameter("date", date.toString());
            return getAvailableMovieSessionQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving available MovieSession "
                    + "where movieId=" + movieId + ", date=" + date, e);
        }
    }
}
