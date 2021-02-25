package ua.vedroid.philharmonic.dao;

import java.util.List;
import java.util.Optional;
import ua.vedroid.philharmonic.model.Stage;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Optional<Stage> getById(Long stageId);
}
