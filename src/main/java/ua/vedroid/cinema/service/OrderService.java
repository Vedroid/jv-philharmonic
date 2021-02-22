package ua.vedroid.cinema.service;

import java.util.List;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;

public interface OrderService {
    Order add(Order order);

    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
