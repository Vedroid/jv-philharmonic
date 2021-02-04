package ua.vedroid.cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.vedroid.cinema.exception.AuthenticationException;
import ua.vedroid.cinema.lib.Injector;
import ua.vedroid.cinema.model.CinemaHall;
import ua.vedroid.cinema.model.Movie;
import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.security.AuthenticationService;
import ua.vedroid.cinema.service.CinemaHallService;
import ua.vedroid.cinema.service.MovieService;
import ua.vedroid.cinema.service.MovieSessionService;
import ua.vedroid.cinema.service.ShoppingCartService;
import ua.vedroid.cinema.service.UserService;

public class Main {
    private static final Injector injector = Injector.getInstance("ua.vedroid.cinema");
    private static final Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        // Movie
        Movie soul = new Movie();
        soul.setTitle("Soul");

        Movie croods = new Movie();
        croods.setTitle("The Croods: A New Age");

        Movie guardians = new Movie();
        guardians.setTitle("Guardians of the Galaxy");

        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(soul);
        movieService.add(croods);
        movieService.add(guardians);

        // CinemaHall
        CinemaHall hallVip = new CinemaHall();
        hallVip.setCapacity(5);
        hallVip.setDescription("VIP");

        CinemaHall hallLux = new CinemaHall();
        hallLux.setCapacity(24);
        hallLux.setDescription("LUX");

        CinemaHall hall = new CinemaHall();
        hall.setCapacity(80);
        hall.setDescription("3D");

        CinemaHallService hallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        hallService.add(hallVip);
        hallService.add(hallLux);
        hallService.add(hall);

        //MovieSession
        MovieSession session1 = new MovieSession();
        session1.setMovie(soul);
        session1.setCinemaHall(hallLux);
        session1.setShowTime(LocalDateTime.parse("2021-02-01T10:30"));

        MovieSession session2 = new MovieSession();
        session2.setMovie(guardians);
        session2.setCinemaHall(hallVip);
        session2.setShowTime(LocalDateTime.parse("2021-02-01T10:45"));

        MovieSession session3 = new MovieSession();
        session3.setMovie(croods);
        session3.setCinemaHall(hall);
        session3.setShowTime(LocalDateTime.parse("2021-02-01T10:00"));

        MovieSession session4 = new MovieSession();
        session4.setMovie(soul);
        session4.setCinemaHall(hall);
        session4.setShowTime(LocalDateTime.parse("2021-02-01T12:20"));

        MovieSession session5 = new MovieSession();
        session5.setMovie(guardians);
        session5.setCinemaHall(hall);
        session5.setShowTime(LocalDateTime.parse("2021-02-02T10:00"));

        MovieSessionService sessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        sessionService.add(session1);
        sessionService.add(session2);
        sessionService.add(session3);
        sessionService.add(session4);
        sessionService.add(session5);

        //Users
        AuthenticationService authenticationService
                = (AuthenticationService) injector.getInstance(AuthenticationService.class);

        User alice = authenticationService.register("alice@gmail.com", "123");
        User bob = authenticationService.register("bob@ukr.net", "qwerty");
        User john = authenticationService.register("nogibator228@mail.ru", "jigurda");
        User bruce = authenticationService.register("380671234567@i.ua", "1996");

        ShoppingCartService shoppingCartService
                = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(session1, alice);
        shoppingCartService.addSession(session1, bob);
        shoppingCartService.addSession(session2, john);
        shoppingCartService.addSession(session3, alice);
        shoppingCartService.addSession(session3, john);
        shoppingCartService.addSession(session4, alice);

        UserService userService =
                (UserService) injector.getInstance(UserService.class);
        //Logs
        log.info("All movies: " + movieService.getAll());
        log.info("All halls: " + hallService.getAll());
        log.info("All sessions: " + sessionService.getAll());
        log.info("All users: " + userService.getAll());
        log.info("All shoppingCarts: " + shoppingCartService.getAll());

        List<MovieSession> availableSessionsGuardians01 = sessionService
                .findAvailableSessions(guardians.getId(), LocalDate.parse("2021-02-01"));
        List<MovieSession> availableSessionsGuardians02 = sessionService
                .findAvailableSessions(guardians.getId(), LocalDate.parse("2021-02-02"));
        List<MovieSession> availableSessionsSoul01 = sessionService
                .findAvailableSessions(soul.getId(), LocalDate.parse("2021-02-01"));
        List<MovieSession> availableSessionsSoul02 = sessionService
                .findAvailableSessions(soul.getId(), LocalDate.parse("2021-02-02"));

        log.info("AvailableSessions(guardians, 2021-02-01): " + availableSessionsGuardians01);
        log.info("AvailableSessions(guardians, 2021-02-02): " + availableSessionsGuardians02);
        log.info("AvailableSessions(soul, 2021-02-01): " + availableSessionsSoul01);
        log.info("AvailableSessions(soul, 2021-02-02): " + availableSessionsSoul02);

        try {
            authenticationService.login(alice.getEmail(), "123");
            log.info("Alice logged in");
            authenticationService.login(bob.getEmail(), "qwerty");
            log.info("Bob logged in");
            authenticationService.login(john.getEmail(), "jigurda");
            log.info("John logged in");
            authenticationService.login(bruce.getEmail(), "1996");
            log.info("Bruce logged in");
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        try {
            authenticationService.login(alice.getEmail(), "wrongPassword");
        } catch (AuthenticationException e) {
            log.info("Alice logged failed, AuthenticationException: " + e.getMessage());
        }

        ShoppingCart byUser = shoppingCartService.getByUser(alice);
        log.info("ShoppingCart by alice: " + byUser);
        shoppingCartService.clear(byUser);
        log.info("Cleared shopping cart: " + byUser);
    }
}
