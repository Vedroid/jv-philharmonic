package ua.vedroid.cinema.dao;

import java.util.Optional;
import ua.vedroid.cinema.model.Movie;

public interface MovieDao extends GenericDao<Movie> {
    Optional<Movie> getByTitle(String movieTitle);
}
