package ua.vedroid.philharmonic.service;

import java.util.Optional;
import ua.vedroid.philharmonic.model.User;

public interface UserService {
    Optional<User> findByEmail(String email);

    User add(User user);

    User get(Long id);
}
