package ua.vedroid.cinema.service.mapper;

import ua.vedroid.cinema.model.Stage;
import ua.vedroid.cinema.model.dto.StageRequestDto;
import ua.vedroid.cinema.model.dto.StageResponseDto;

public interface StageMapper extends GenericDtoMapper<Stage, StageResponseDto>,
        GenericEntityMapper<Stage, StageRequestDto> {
}
