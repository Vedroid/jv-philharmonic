package ua.vedroid.cinema.service.mapper.impl;

import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.model.dto.UserRequestDto;
import ua.vedroid.cinema.model.dto.UserResponseDto;
import ua.vedroid.cinema.service.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @Override
    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
