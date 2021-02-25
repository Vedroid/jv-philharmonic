package ua.vedroid.philharmonic.service.mapper;

import ua.vedroid.philharmonic.model.Stage;
import ua.vedroid.philharmonic.model.dto.StageRequestDto;
import ua.vedroid.philharmonic.model.dto.StageResponseDto;

public interface StageMapper extends GenericDtoMapper<Stage, StageResponseDto>,
        GenericEntityMapper<Stage, StageRequestDto> {
}
