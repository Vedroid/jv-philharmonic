package ua.vedroid.philharmonic.dao;

import java.util.List;
import java.util.Optional;
import ua.vedroid.philharmonic.model.Concert;

public interface ConcertDao {
    Concert add(Concert concert);

    List<Concert> getAll();

    Optional<Concert> getByTitle(String movieTitle);
}
