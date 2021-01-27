package ua.vedroid.cinema.dao;

import java.util.List;
import ua.vedroid.cinema.model.Movie;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
