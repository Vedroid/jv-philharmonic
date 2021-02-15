package ua.vedroid.cinema.security;

import ua.vedroid.cinema.exception.AuthenticationException;
import ua.vedroid.cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(User user);
}
