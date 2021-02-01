package ua.vedroid.cinema.service;

import java.time.LocalDate;
import java.util.List;
import ua.vedroid.cinema.model.MovieSession;

public interface MovieSessionService extends GenericService<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}
