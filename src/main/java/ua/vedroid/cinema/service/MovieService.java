package ua.vedroid.cinema.service;

import ua.vedroid.cinema.model.Movie;

public interface MovieService extends GenericService<Movie> {
    Movie getByTitle(String movieTitle);
}
