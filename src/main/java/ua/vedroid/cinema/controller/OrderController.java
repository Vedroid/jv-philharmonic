package ua.vedroid.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.User;
import ua.vedroid.cinema.model.dto.OrderResponseDto;
import ua.vedroid.cinema.service.OrderService;
import ua.vedroid.cinema.service.ShoppingCartService;
import ua.vedroid.cinema.service.UserService;
import ua.vedroid.cinema.service.mapper.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderMapper mapper;

    @Autowired
    public OrderController(OrderService service, UserService userService,
                           ShoppingCartService shoppingCartService, OrderMapper mapper) {
        this.orderService = service;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrderResponseDto> getHistory(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName()).get();
        return orderService.getOrdersHistory(user).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName()).get();
        return mapper.toDto(orderService.completeOrder(shoppingCartService.getByUser(user)));
    }
}
