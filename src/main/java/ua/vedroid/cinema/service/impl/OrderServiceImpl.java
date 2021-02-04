package ua.vedroid.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import ua.vedroid.cinema.dao.OrderDao;
import ua.vedroid.cinema.lib.Inject;
import ua.vedroid.cinema.lib.Service;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.service.OrderService;
import ua.vedroid.cinema.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setTickets(shoppingCart.getTickets());
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clear(shoppingCart);
        return add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
