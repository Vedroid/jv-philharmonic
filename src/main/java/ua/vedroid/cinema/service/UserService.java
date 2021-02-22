package ua.vedroid.cinema.service;

import java.util.Optional;
import ua.vedroid.cinema.model.User;

public interface UserService {
    Optional<User> findByEmail(String email);

    User add(User user);

    User get(Long id);
}
