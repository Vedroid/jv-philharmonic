package ua.vedroid.cinema.service.mapper.impl;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.vedroid.cinema.model.Order;
import ua.vedroid.cinema.model.Ticket;
import ua.vedroid.cinema.model.dto.OrderResponseDto;
import ua.vedroid.cinema.service.mapper.OrderMapper;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setTicketIds(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        dto.setUserEmail(order.getUser().getEmail());
        dto.setOrderDate(order.getOrderDate().toString());
        return dto;
    }
}
