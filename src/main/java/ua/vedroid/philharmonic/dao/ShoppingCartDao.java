package ua.vedroid.philharmonic.dao;

import java.util.Optional;
import ua.vedroid.philharmonic.model.ShoppingCart;
import ua.vedroid.philharmonic.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    Optional<ShoppingCart> getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
