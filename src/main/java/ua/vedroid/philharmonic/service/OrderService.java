package ua.vedroid.philharmonic.service;

import java.util.List;
import ua.vedroid.philharmonic.model.Order;
import ua.vedroid.philharmonic.model.ShoppingCart;
import ua.vedroid.philharmonic.model.User;

public interface OrderService {
    Order add(Order order);

    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
