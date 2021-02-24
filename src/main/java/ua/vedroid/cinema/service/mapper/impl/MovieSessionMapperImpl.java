package ua.vedroid.cinema.service.mapper.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.model.dto.MovieSessionRequestDto;
import ua.vedroid.cinema.model.dto.MovieSessionResponseDto;
import ua.vedroid.cinema.service.CinemaHallService;
import ua.vedroid.cinema.service.ConcertService;
import ua.vedroid.cinema.service.mapper.MovieSessionMapper;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    private final ConcertService concertService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapperImpl(ConcertService concertService, CinemaHallService cinemaHallService) {
        this.concertService = concertService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovieTitle(movieSession.getMovie().getTitle());
        dto.setCinemaHallId(String.valueOf(movieSession.getCinemaHall().getId()));
        dto.setShowTime(movieSession.getShowTime().toString());
        return dto;
    }

    @Override
    public MovieSession toEntity(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(concertService.getByTitle(dto.getMovieTitle()));
        movieSession.setCinemaHall(cinemaHallService.getById(dto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime()));
        return movieSession;
    }
}
