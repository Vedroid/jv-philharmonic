package ua.vedroid.philharmonic.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.dao.ShoppingCartDao;
import ua.vedroid.philharmonic.dao.TicketDao;
import ua.vedroid.philharmonic.model.ConcertSession;
import ua.vedroid.philharmonic.model.ShoppingCart;
import ua.vedroid.philharmonic.model.Ticket;
import ua.vedroid.philharmonic.model.User;
import ua.vedroid.philharmonic.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void addSession(ConcertSession concertSession, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Ticket ticket = new Ticket();
        ticket.setConcertSession(concertSession);
        ticket.setUser(user);
        shoppingCart.getTickets().add(ticket);
        ticketDao.add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user).get();
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
