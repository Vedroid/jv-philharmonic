package ua.vedroid.cinema.dao;

import java.util.Optional;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    Optional<ShoppingCart> getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
