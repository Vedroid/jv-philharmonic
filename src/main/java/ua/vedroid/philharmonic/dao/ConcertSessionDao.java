package ua.vedroid.philharmonic.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import ua.vedroid.philharmonic.model.ConcertSession;

public interface ConcertSessionDao {
    ConcertSession add(ConcertSession concertSession);

    Optional<ConcertSession> get(Long id);

    List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date);

    ConcertSession update(ConcertSession concertSession);

    ConcertSession delete(Long id);
}
