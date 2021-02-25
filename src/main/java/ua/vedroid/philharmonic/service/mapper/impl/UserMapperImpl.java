package ua.vedroid.philharmonic.service.mapper.impl;

import org.springframework.stereotype.Component;
import ua.vedroid.philharmonic.model.User;
import ua.vedroid.philharmonic.model.dto.UserResponseDto;
import ua.vedroid.philharmonic.service.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
