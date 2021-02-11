package ua.vedroid.cinema.service.mapper.impl;

import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.CinemaHall;
import ua.vedroid.cinema.model.dto.CinemaHallRequestDto;
import ua.vedroid.cinema.model.dto.CinemaHallResponseDto;
import ua.vedroid.cinema.service.mapper.CinemaHallMapper;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        return dto;
    }

    @Override
    public CinemaHall toEntity(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }
}
