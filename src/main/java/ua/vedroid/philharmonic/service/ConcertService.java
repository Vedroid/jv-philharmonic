package ua.vedroid.philharmonic.service;

import java.util.List;
import ua.vedroid.philharmonic.model.Concert;

public interface ConcertService {
    Concert add(Concert concert);

    List<Concert> getAll();

    Concert getByTitle(String movieTitle);
}
