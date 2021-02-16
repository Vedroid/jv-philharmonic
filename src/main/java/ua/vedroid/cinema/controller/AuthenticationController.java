package ua.vedroid.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.dto.UserRequestDto;
import ua.vedroid.cinema.security.AuthenticationService;
import ua.vedroid.cinema.service.mapper.UserMapper;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserMapper mapper;

    @Autowired
    public AuthenticationController(AuthenticationService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto dto) {
        service.register(dto.getEmail(), dto.getPassword());
    }
}
