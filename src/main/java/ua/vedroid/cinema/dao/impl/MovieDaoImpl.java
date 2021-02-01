package ua.vedroid.cinema.dao.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.vedroid.cinema.dao.MovieDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.lib.Dao;
import ua.vedroid.cinema.model.Movie;
import ua.vedroid.cinema.util.HibernateUtil;

@Dao
public class MovieDaoImpl implements MovieDao {
    static final Logger log = LogManager.getLogger(MovieDaoImpl.class);

    @Override
    public Movie add(Movie movie) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
            log.info("Added new movie: " + movie);
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can`t insert Movie entity " + movie;
            log.error(msg, e);
            throw new DataProcessingException(msg, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Movie> getAllMoviesQuery = session.createQuery("from Movie", Movie.class);
            return getAllMoviesQuery.getResultList();
        } catch (Exception e) {
            String msg = "Error retrieving all movies";
            log.error(msg, e);
            throw new DataProcessingException(msg, e);
        }
    }
}
