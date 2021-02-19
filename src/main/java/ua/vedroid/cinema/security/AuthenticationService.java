package ua.vedroid.cinema.security;

import ua.vedroid.cinema.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
