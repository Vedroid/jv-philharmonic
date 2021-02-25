package ua.vedroid.philharmonic.service;

import java.util.List;
import ua.vedroid.philharmonic.model.Stage;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage getById(Long cinemaHallId);
}
