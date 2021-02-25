package ua.vedroid.philharmonic.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.vedroid.philharmonic.dao.ConcertSessionDao;
import ua.vedroid.philharmonic.exception.DataProcessingException;
import ua.vedroid.philharmonic.model.ConcertSession;

@Repository
public class ConcertSessionDaoImpl implements ConcertSessionDao {
    private static final Logger log = LogManager.getLogger(ConcertSessionDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public ConcertSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ConcertSession add(ConcertSession concertSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concertSession);
            transaction.commit();
            log.info("Added new concertSession: " + concertSession);
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert ConcertSession entity "
                    + concertSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<ConcertSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from ConcertSession ms "
                    + "left join fetch ms.cinemaHall "
                    + "left join fetch ms.movie "
                    + "where ms.id = :id", ConcertSession.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving ConcertSession where Id=" + id, e);
        }
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from ConcertSession ms "
                    + "left join fetch ms.cinemaHall "
                    + "left join fetch ms.movie "
                    + "where ms.movie.id = :id "
                    + "and to_char(ms.showTime, 'YYYY-MM-DD') = :date", ConcertSession.class)
                    .setParameter("id", movieId)
                    .setParameter("date", date.toString())
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving available ConcertSession "
                    + "where movieId=" + movieId + ", date=" + date, e);
        }
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(concertSession);
            transaction.commit();
            log.info("Updated concertSession: " + concertSession);
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t updated ConcertSession entity "
                    + concertSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ConcertSession delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ConcertSession concertSession =
                    session.createQuery("delete ConcertSession where id = :id",
                            ConcertSession.class)
                            .setParameter("id", id)
                            .getSingleResult();
            transaction.commit();
            log.info("Deleted concertSession: " + concertSession);
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t deleted ConcertSession entity where id="
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
