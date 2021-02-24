package ua.vedroid.philharmonic.service.mapper;

import ua.vedroid.philharmonic.model.Concert;
import ua.vedroid.philharmonic.model.dto.ConcertRequestDto;
import ua.vedroid.philharmonic.model.dto.ConcertResponseDto;

public interface ConcertMapper extends GenericDtoMapper<Concert, ConcertResponseDto>,
        GenericEntityMapper<Concert, ConcertRequestDto> {
}
