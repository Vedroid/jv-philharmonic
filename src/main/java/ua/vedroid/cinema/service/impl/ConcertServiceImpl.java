package ua.vedroid.cinema.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.cinema.dao.MovieDao;
import ua.vedroid.cinema.model.Concert;
import ua.vedroid.cinema.service.ConcertService;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final MovieDao movieDao;

    @Autowired
    public ConcertServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Concert add(Concert concert) {
        return movieDao.add(concert);
    }

    @Override
    public List<Concert> getAll() {
        return movieDao.getAll();
    }

    @Override
    public Concert getByTitle(String movieTitle) {
        return movieDao.getByTitle(movieTitle).get();
    }
}
