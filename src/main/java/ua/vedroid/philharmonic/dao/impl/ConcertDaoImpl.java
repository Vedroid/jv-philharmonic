package ua.vedroid.philharmonic.dao.impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.vedroid.philharmonic.dao.ConcertDao;
import ua.vedroid.philharmonic.exception.DataProcessingException;
import ua.vedroid.philharmonic.model.Concert;

@Repository
public class ConcertDaoImpl implements ConcertDao {
    private static final Logger log = LogManager.getLogger(ConcertDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public ConcertDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Concert add(Concert concert) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concert);
            transaction.commit();
            log.info("Added new concert: " + concert);
            return concert;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert Concert entity " + concert, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Concert> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Concert", Concert.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all Movies", e);
        }
    }

    @Override
    public Optional<Concert> getByTitle(String movieTitle) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Concert where title = :title", Concert.class)
                    .setParameter("title", movieTitle)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving Concert where title="
                    + movieTitle, e);
        }
    }
}
