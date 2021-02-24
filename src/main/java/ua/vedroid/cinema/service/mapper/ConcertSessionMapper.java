package ua.vedroid.cinema.service.mapper;

import ua.vedroid.cinema.model.ConcertSession;
import ua.vedroid.cinema.model.dto.ConcertSessionRequestDto;
import ua.vedroid.cinema.model.dto.ConcertSessionResponseDto;

public interface ConcertSessionMapper extends GenericDtoMapper<ConcertSession, ConcertSessionResponseDto>,
        GenericEntityMapper<ConcertSession, ConcertSessionRequestDto> {
}
