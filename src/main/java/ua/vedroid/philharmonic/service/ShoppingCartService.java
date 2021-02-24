package ua.vedroid.philharmonic.service;

import ua.vedroid.philharmonic.model.ConcertSession;
import ua.vedroid.philharmonic.model.ShoppingCart;
import ua.vedroid.philharmonic.model.User;

public interface ShoppingCartService {
    ShoppingCart add(ShoppingCart shoppingCart);

    void addSession(ConcertSession concertSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
