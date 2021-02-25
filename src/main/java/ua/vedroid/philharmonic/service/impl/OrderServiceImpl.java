package ua.vedroid.philharmonic.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.dao.OrderDao;
import ua.vedroid.philharmonic.model.Order;
import ua.vedroid.philharmonic.model.ShoppingCart;
import ua.vedroid.philharmonic.model.User;
import ua.vedroid.philharmonic.service.OrderService;
import ua.vedroid.philharmonic.service.ShoppingCartService;

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
