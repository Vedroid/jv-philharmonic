package ua.vedroid.cinema.service.mapper.impl;

import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.Stage;
import ua.vedroid.cinema.model.dto.StageRequestDto;
import ua.vedroid.cinema.model.dto.StageResponseDto;
import ua.vedroid.cinema.service.mapper.StageMapper;

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
