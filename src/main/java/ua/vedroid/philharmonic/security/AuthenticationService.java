package ua.vedroid.philharmonic.security;

import ua.vedroid.philharmonic.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
