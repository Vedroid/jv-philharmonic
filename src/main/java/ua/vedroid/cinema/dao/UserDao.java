package ua.vedroid.cinema.dao;

import java.util.Optional;
import ua.vedroid.cinema.model.User;

public interface UserDao extends GenericDao<User> {
    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
