package ua.vedroid.cinema.dao;

import java.util.List;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
