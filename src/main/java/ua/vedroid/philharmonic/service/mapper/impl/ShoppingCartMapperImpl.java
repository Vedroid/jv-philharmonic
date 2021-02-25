package ua.vedroid.philharmonic.service.mapper.impl;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.vedroid.philharmonic.model.ShoppingCart;
import ua.vedroid.philharmonic.model.Ticket;
import ua.vedroid.philharmonic.model.dto.ShoppingCartResponseDto;
import ua.vedroid.philharmonic.service.mapper.ShoppingCartMapper;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(shoppingCart.getId());
        dto.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
