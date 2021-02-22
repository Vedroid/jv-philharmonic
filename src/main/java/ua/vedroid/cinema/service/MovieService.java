package ua.vedroid.cinema.service;

import java.util.List;
import ua.vedroid.cinema.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie getByTitle(String movieTitle);
}
