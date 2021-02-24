package ua.vedroid.cinema.service.mapper.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.ConcertSession;
import ua.vedroid.cinema.model.dto.ConcertSessionRequestDto;
import ua.vedroid.cinema.model.dto.ConcertSessionResponseDto;
import ua.vedroid.cinema.service.StageService;
import ua.vedroid.cinema.service.ConcertService;
import ua.vedroid.cinema.service.mapper.ConcertSessionMapper;

@Component
public class ConcertSessionMapperImpl implements ConcertSessionMapper {
    private final ConcertService concertService;
    private final StageService stageService;

    @Autowired
    public ConcertSessionMapperImpl(ConcertService concertService, StageService stageService) {
        this.concertService = concertService;
        this.stageService = stageService;
    }

    @Override
    public ConcertSessionResponseDto toDto(ConcertSession concertSession) {
        ConcertSessionResponseDto dto = new ConcertSessionResponseDto();
        dto.setId(concertSession.getId());
        dto.setMovieTitle(concertSession.getMovie().getTitle());
        dto.setCinemaHallId(String.valueOf(concertSession.getCinemaHall().getId()));
        dto.setShowTime(concertSession.getShowTime().toString());
        return dto;
    }

    @Override
    public ConcertSession toEntity(ConcertSessionRequestDto dto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setMovie(concertService.getByTitle(dto.getMovieTitle()));
        concertSession.setCinemaHall(stageService.getById(dto.getCinemaHallId()));
        concertSession.setShowTime(LocalDateTime.parse(dto.getShowTime()));
        return concertSession;
    }
}
