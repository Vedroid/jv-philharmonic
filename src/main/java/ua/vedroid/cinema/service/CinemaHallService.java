package ua.vedroid.cinema.service;

import java.util.List;
import ua.vedroid.cinema.model.CinemaHall;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    CinemaHall getById(Long cinemaHallId);
}
