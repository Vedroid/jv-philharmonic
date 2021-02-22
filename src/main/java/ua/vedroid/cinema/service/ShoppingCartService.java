package ua.vedroid.cinema.service;

import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;

public interface ShoppingCartService {
    ShoppingCart add(ShoppingCart shoppingCart);

    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
