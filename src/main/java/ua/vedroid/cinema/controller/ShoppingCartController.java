package ua.vedroid.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.dto.ShoppingCartDto;
import ua.vedroid.cinema.service.MovieSessionService;
import ua.vedroid.cinema.service.ShoppingCartService;
import ua.vedroid.cinema.service.UserService;
import ua.vedroid.cinema.service.mapper.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartMapper mapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartMapper mapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/by-user")
    public ShoppingCartDto getByUser(@RequestParam Long userId) {
        return mapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }
}
