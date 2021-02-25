package ua.vedroid.philharmonic.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.dao.ConcertSessionDao;
import ua.vedroid.philharmonic.model.ConcertSession;
import ua.vedroid.philharmonic.service.ConcertSessionService;

@Service
public class ConcertSessionServiceImpl implements ConcertSessionService {
    private final ConcertSessionDao concertSessionDao;

    @Autowired
    public ConcertSessionServiceImpl(ConcertSessionDao concertSessionDao) {
        this.concertSessionDao = concertSessionDao;
    }

    @Override
    public ConcertSession get(Long id) {
        return concertSessionDao.get(id).get();
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date) {
        return concertSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public ConcertSession add(ConcertSession session) {
        return concertSessionDao.add(session);
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        return concertSessionDao.update(concertSession);
    }

    @Override
    public ConcertSession delete(Long id) {
        return concertSessionDao.delete(id);
    }
}
