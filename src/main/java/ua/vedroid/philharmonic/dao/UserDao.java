package ua.vedroid.philharmonic.dao;

import java.util.Optional;
import ua.vedroid.philharmonic.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
