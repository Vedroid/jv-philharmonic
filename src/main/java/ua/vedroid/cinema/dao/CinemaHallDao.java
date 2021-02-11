package ua.vedroid.cinema.dao;

import java.util.Optional;
import ua.vedroid.cinema.model.CinemaHall;

public interface CinemaHallDao extends GenericDao<CinemaHall> {
    Optional<CinemaHall> getById(Long cinemaHallId);
}
