package ua.vedroid.philharmonic.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.dao.ConcertDao;
import ua.vedroid.philharmonic.model.Concert;
import ua.vedroid.philharmonic.service.ConcertService;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    @Autowired
    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }

    @Override
    public Concert getByTitle(String movieTitle) {
        return concertDao.getByTitle(movieTitle).get();
    }
}
