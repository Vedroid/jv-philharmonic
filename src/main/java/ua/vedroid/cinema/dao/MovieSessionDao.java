package ua.vedroid.cinema.dao;

import java.time.LocalDate;
import java.util.List;
import ua.vedroid.cinema.model.MovieSession;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    MovieSession delete(Long id);
}
