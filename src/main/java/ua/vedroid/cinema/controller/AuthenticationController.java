package ua.vedroid.cinema.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.dto.UserRegistrationDto;
import ua.vedroid.cinema.security.AuthenticationService;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRegistrationDto dto) {
        service.register(dto.getEmail(), dto.getPassword());
    }
}
