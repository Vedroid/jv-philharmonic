package ua.vedroid.cinema.dao;

import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
