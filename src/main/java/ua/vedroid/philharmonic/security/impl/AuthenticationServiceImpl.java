package ua.vedroid.philharmonic.security.impl;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.model.User;
import ua.vedroid.philharmonic.security.AuthenticationService;
import ua.vedroid.philharmonic.service.RoleService;
import ua.vedroid.philharmonic.service.ShoppingCartService;
import ua.vedroid.philharmonic.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User newUser = new User(email, password);
        newUser.setRoles(Set.of(roleService.getRoleByName("USER")));
        User user = userService.add(newUser);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
