package ua.vedroid.philharmonic.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.vedroid.philharmonic.model.User;
import ua.vedroid.philharmonic.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username).orElseThrow(()
                -> new UsernameNotFoundException("User " + username + " could not be found"));
        return withUsername(username)
                .password(user.getPassword())
                .roles(user.getRoles()
                        .stream()
                        .map(role -> role.getRoleName().toString())
                        .toArray(String[]::new))
                .build();
    }
}
