package ua.vedroid.philharmonic.service.mapper;

import ua.vedroid.philharmonic.model.ConcertSession;
import ua.vedroid.philharmonic.model.dto.ConcertSessionRequestDto;
import ua.vedroid.philharmonic.model.dto.ConcertSessionResponseDto;

public interface ConcertSessionMapper
        extends GenericDtoMapper<ConcertSession, ConcertSessionResponseDto>,
        GenericEntityMapper<ConcertSession, ConcertSessionRequestDto> {
}
