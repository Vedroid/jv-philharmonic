package ua.vedroid.cinema.service.mapper.impl;

import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.Concert;
import ua.vedroid.cinema.model.dto.ConcertRequestDto;
import ua.vedroid.cinema.model.dto.ConcertResponseDto;
import ua.vedroid.cinema.service.mapper.ConcertMapper;

@Component
public class ConcertMapperImpl implements ConcertMapper {
    @Override
    public ConcertResponseDto toDto(Concert concert) {
        ConcertResponseDto dto = new ConcertResponseDto();
        dto.setId(concert.getId());
        dto.setTitle(concert.getTitle());
        dto.setDescription(concert.getDescription());
        return dto;
    }

    @Override
    public Concert toEntity(ConcertRequestDto dto) {
        Concert concert = new Concert();
        concert.setTitle(dto.getTitle());
        concert.setDescription(dto.getDescription());
        return concert;
    }
}
