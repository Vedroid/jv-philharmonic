package ua.vedroid.philharmonic.dao;

import java.util.List;
import ua.vedroid.philharmonic.model.Order;
import ua.vedroid.philharmonic.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
