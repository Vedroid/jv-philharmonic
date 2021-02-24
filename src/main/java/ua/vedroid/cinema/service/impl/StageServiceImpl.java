package ua.vedroid.cinema.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.cinema.dao.StageHallDao;
import ua.vedroid.cinema.model.Stage;
import ua.vedroid.cinema.service.StageService;

@Service
public class StageServiceImpl implements StageService {
    private final StageHallDao stageHallDao;

    @Autowired
    public StageServiceImpl(StageHallDao stageHallDao) {
        this.stageHallDao = stageHallDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageHallDao.add(stage);
    }

    @Override
    public List<Stage> getAll() {
        return stageHallDao.getAll();
    }

    @Override
    public Stage getById(Long cinemaHallId) {
        return stageHallDao.getById(cinemaHallId).get();
    }
}
