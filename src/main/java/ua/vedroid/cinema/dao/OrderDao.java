package ua.vedroid.cinema.dao;

import java.util.List;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.User;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(User user);
}
