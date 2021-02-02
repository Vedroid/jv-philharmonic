package ua.vedroid.cinema.security.impl;

import java.util.Optional;
import ua.vedroid.cinema.exception.AuthenticationException;
import ua.vedroid.cinema.lib.Inject;
import ua.vedroid.cinema.lib.Service;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.security.AuthenticationService;
import ua.vedroid.cinema.service.UserService;
import ua.vedroid.cinema.util.HashUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent() && user.get().getPassword()
                .equals(HashUtil.hashPassword(password, user.get().getSalt()))) {
            return user.get();
        }

        throw new AuthenticationException("Incorrect login or password");
    }

    @Override
    public User register(String email, String password) {
        return userService.add(new User(email, password));
    }
}
