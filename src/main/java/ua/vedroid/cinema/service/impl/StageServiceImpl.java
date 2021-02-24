package ua.vedroid.cinema.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.cinema.dao.StageDao;
import ua.vedroid.cinema.model.Stage;
import ua.vedroid.cinema.service.StageService;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    @Autowired
    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }

    @Override
    public Stage getById(Long cinemaHallId) {
        return stageDao.getById(cinemaHallId).get();
    }
}
