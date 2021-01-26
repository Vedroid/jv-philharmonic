package ua.vedroid.cinema;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.vedroid.cinema.lib.Injector;
import ua.vedroid.cinema.model.Movie;
import ua.vedroid.cinema.service.MovieService;

public class Main {
    private static final Injector injector = Injector.getInstance("ua.vedroid.cinema");
    static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        log.info("All movies: " + movieService.getAll());
    }
}
