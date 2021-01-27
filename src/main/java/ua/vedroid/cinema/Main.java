package ua.vedroid.cinema;

import ua.vedroid.cinema.lib.Injector;
import ua.vedroid.cinema.model.Movie;
import ua.vedroid.cinema.service.MovieService;

public class Main {
    private static final Injector injector = Injector.getInstance("ua.vedroid.cinema");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
