package ua.vedroid.cinema.dao;

import java.util.List;
import java.util.Optional;
import ua.vedroid.cinema.model.Concert;

public interface MovieDao {
    Concert add(Concert concert);

    List<Concert> getAll();

    Optional<Concert> getByTitle(String movieTitle);
}
