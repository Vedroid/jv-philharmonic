package ua.vedroid.cinema.service.mapper;

import ua.vedroid.cinema.model.Concert;
import ua.vedroid.cinema.model.dto.ConcertRequestDto;
import ua.vedroid.cinema.model.dto.ConcertResponseDto;

public interface ConcertMapper extends GenericDtoMapper<Concert, ConcertResponseDto>,
        GenericEntityMapper<Concert, ConcertRequestDto> {
}
