package ua.vedroid.cinema.service.mapper.impl;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.ShoppingCart;
import ua.vedroid.cinema.model.Ticket;
import ua.vedroid.cinema.model.dto.ShoppingCartDto;
import ua.vedroid.cinema.service.mapper.ShoppingCartMapper;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartDto dto = new ShoppingCartDto();
        dto.setId(shoppingCart.getId());
        dto.setUserId(shoppingCart.getUser().getId());
        dto.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return dto;
    }

    // TODO
    @Override
    public ShoppingCart toEntity(ShoppingCartDto dto) {
        return null;
    }
}
