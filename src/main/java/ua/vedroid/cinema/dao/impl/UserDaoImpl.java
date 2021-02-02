package ua.vedroid.cinema.dao.impl;

import java.util.List;
import java.util.Optional;
import ua.vedroid.cinema.dao.UserDao;
import ua.vedroid.cinema.lib.Dao;
import ua.vedroid.cinema.model.User;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

}
