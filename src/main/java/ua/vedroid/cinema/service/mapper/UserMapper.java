package ua.vedroid.cinema.service.mapper;

import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.model.dto.UserRequestDto;
import ua.vedroid.cinema.model.dto.UserResponseDto;

public interface UserMapper extends GenericDtoMapper<User, UserResponseDto>,
        GenericEntityMapper<User, UserRequestDto> {
}
