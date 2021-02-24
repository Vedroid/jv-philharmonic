package ua.vedroid.cinema.service;

import java.time.LocalDate;
import java.util.List;
import ua.vedroid.cinema.model.ConcertSession;

public interface ConcertSessionService {
    ConcertSession add(ConcertSession session);

    ConcertSession get(Long id);

    List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date);

    ConcertSession update(ConcertSession concertSession);

    ConcertSession delete(Long id);
}
