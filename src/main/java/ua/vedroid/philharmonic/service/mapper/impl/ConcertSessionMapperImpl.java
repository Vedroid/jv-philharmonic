package ua.vedroid.philharmonic.service.mapper.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vedroid.philharmonic.model.ConcertSession;
import ua.vedroid.philharmonic.model.dto.ConcertSessionRequestDto;
import ua.vedroid.philharmonic.model.dto.ConcertSessionResponseDto;
import ua.vedroid.philharmonic.service.ConcertService;
import ua.vedroid.philharmonic.service.StageService;
import ua.vedroid.philharmonic.service.mapper.ConcertSessionMapper;

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
        dto.setConcertTitle(concertSession.getConcert().getTitle());
        dto.setStageId(String.valueOf(concertSession.getStage().getId()));
        dto.setShowTime(concertSession.getShowTime().toString());
        return dto;
    }

    @Override
    public ConcertSession toEntity(ConcertSessionRequestDto dto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setConcert(concertService.getByTitle(dto.getConcertTitle()));
        concertSession.setStage(stageService.getById(dto.getStageId()));
        concertSession.setShowTime(LocalDateTime.parse(dto.getShowTime()));
        return concertSession;
    }
}
