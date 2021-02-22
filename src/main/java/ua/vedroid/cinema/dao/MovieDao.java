package ua.vedroid.cinema.dao;

import java.util.List;
import java.util.Optional;
import ua.vedroid.cinema.model.Movie;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();

    Optional<Movie> getByTitle(String movieTitle);
}
