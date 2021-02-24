package ua.vedroid.cinema.service;

import java.util.List;
import ua.vedroid.cinema.model.Stage;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage getById(Long cinemaHallId);
}
