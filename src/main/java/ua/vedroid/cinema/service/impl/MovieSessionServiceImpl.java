package ua.vedroid.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.cinema.dao.MovieSessionDao;
import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private MovieSessionDao movieSessionDao;

    @Autowired
    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public List<MovieSession> getAll() {
        return movieSessionDao.getAll();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
