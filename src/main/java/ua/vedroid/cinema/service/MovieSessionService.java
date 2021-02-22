package ua.vedroid.cinema.service;

import java.time.LocalDate;
import java.util.List;
import ua.vedroid.cinema.model.MovieSession;

public interface MovieSessionService {
    MovieSession add(MovieSession session);

    MovieSession get(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    MovieSession delete(Long id);
}
