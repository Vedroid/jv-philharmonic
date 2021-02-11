package ua.vedroid.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.cinema.dao.OrderDao;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.service.OrderService;
import ua.vedroid.cinema.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

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
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
        Order newOrder = add(order);
        shoppingCartService.clear(shoppingCart);
        return newOrder;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
