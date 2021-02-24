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
import ua.vedroid.cinema.dao.StageHallDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.model.Stage;

@Repository
public class StageDaoImpl implements StageHallDao {
    private static final Logger log = LogManager.getLogger(StageDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public StageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Stage add(Stage stage) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(stage);
            transaction.commit();
            log.info("Added new stage: " + stage);
            return stage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert Stage entity " + stage, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Stage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Stage", Stage.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all Stage", e);
        }
    }

    @Override
    public Optional<Stage> getById(Long cinemaHallId) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Stage.class, cinemaHallId));
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving Stage where id="
                    + cinemaHallId, e);
        }
    }
}
