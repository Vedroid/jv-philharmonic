package ua.vedroid.philharmonic.service.mapper.impl;

import org.springframework.stereotype.Component;
import ua.vedroid.philharmonic.model.Stage;
import ua.vedroid.philharmonic.model.dto.StageRequestDto;
import ua.vedroid.philharmonic.model.dto.StageResponseDto;
import ua.vedroid.philharmonic.service.mapper.StageMapper;

@Component
public class StageMapperImpl implements StageMapper {
    @Override
    public StageResponseDto toDto(Stage stage) {
        StageResponseDto dto = new StageResponseDto();
        dto.setId(stage.getId());
        dto.setCapacity(stage.getCapacity());
        dto.setDescription(stage.getDescription());
        return dto;
    }

    @Override
    public Stage toEntity(StageRequestDto dto) {
        Stage stage = new Stage();
        stage.setCapacity(dto.getCapacity());
        stage.setDescription(dto.getDescription());
        return stage;
    }
}
