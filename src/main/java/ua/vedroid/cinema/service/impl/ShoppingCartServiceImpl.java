package ua.vedroid.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;
import ua.vedroid.cinema.dao.ShoppingCartDao;
import ua.vedroid.cinema.dao.TicketDao;
import ua.vedroid.cinema.lib.Inject;
import ua.vedroid.cinema.lib.Service;
import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.Ticket;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private TicketDao ticketDao;

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return shoppingCartDao.add(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return shoppingCartDao.getAll();
    }

    @Override
    public void addSession(MovieSession movieSession, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        shoppingCart.getTickets().add(ticket);
        ticketDao.add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(new ArrayList<>());
        shoppingCartDao.update(shoppingCart);
    }
}
