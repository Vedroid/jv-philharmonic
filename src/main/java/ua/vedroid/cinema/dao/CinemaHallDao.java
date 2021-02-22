package ua.vedroid.cinema.dao;

import java.util.List;
import java.util.Optional;
import ua.vedroid.cinema.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    Optional<CinemaHall> getById(Long cinemaHallId);
}
