package ua.vedroid.philharmonic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.philharmonic.model.User;
import ua.vedroid.philharmonic.model.dto.ShoppingCartResponseDto;
import ua.vedroid.philharmonic.service.ConcertSessionService;
import ua.vedroid.philharmonic.service.ShoppingCartService;
import ua.vedroid.philharmonic.service.UserService;
import ua.vedroid.philharmonic.service.mapper.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ConcertSessionService concertSessionService;
    private final UserService userService;
    private final ShoppingCartMapper mapper;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ConcertSessionService concertSessionService,
                                  UserService userService,
                                  ShoppingCartMapper mapper) {
        this.shoppingCartService = shoppingCartService;
        this.concertSessionService = concertSessionService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName()).get();
        return mapper.toDto(shoppingCartService.getByUser(user));
    }

    @PostMapping("/concert-sessions")
    public void addConcertSession(Authentication authentication,
                                  @RequestParam Long concertSessionId) {
        User user = userService.findByEmail(authentication.getName()).get();
        shoppingCartService.addSession(concertSessionService.get(concertSessionId), user);
    }
}
