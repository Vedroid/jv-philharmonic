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
            log.error("Can`t insert Movie entity", e);
            throw new DataProcessingException("Can`t insert Movie entity " + movie, e);
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
            log.error("Error retrieving all movies", e);
            throw new DataProcessingException("Error retrieving all movies", e);
        }
    }
}
