package ua.vedroid.cinema.service;

import java.util.Optional;
import ua.vedroid.cinema.model.User;

public interface UserService extends GenericService<User> {
    Optional<User> findByEmail(String email);
}
