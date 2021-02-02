package ua.vedroid.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import ua.vedroid.cinema.dao.UserDao;
import ua.vedroid.cinema.lib.Inject;
import ua.vedroid.cinema.lib.Service;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
