package ua.vedroid.philharmonic.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.dao.StageDao;
import ua.vedroid.philharmonic.model.Stage;
import ua.vedroid.philharmonic.service.StageService;

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
