package ua.vedroid.cinema.service;

import java.util.List;
import ua.vedroid.cinema.model.Concert;

public interface ConcertService {
    Concert add(Concert concert);

    List<Concert> getAll();

    Concert getByTitle(String movieTitle);
}
