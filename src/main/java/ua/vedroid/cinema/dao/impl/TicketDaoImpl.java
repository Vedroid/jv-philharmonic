package ua.vedroid.cinema.dao.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ua.vedroid.cinema.dao.TicketDao;
import ua.vedroid.cinema.exception.DataProcessingException;
import ua.vedroid.cinema.model.Ticket;
import ua.vedroid.cinema.util.HibernateUtil;

@Repository
public class TicketDaoImpl implements TicketDao {
    private static final Logger log = LogManager.getLogger(TicketDaoImpl.class);

    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            log.info("Added new ticket: " + ticket);
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t insert ticket entity " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Ticket> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all Tickets", e);
        }
    }
}
