package ua.vedroid.cinema.dao;

import java.util.List;
import java.util.Optional;
import ua.vedroid.cinema.model.Stage;

public interface StageHallDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Optional<Stage> getById(Long cinemaHallId);
}
