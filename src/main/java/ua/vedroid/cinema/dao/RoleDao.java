package ua.vedroid.cinema.dao;

import java.util.Optional;
import ua.vedroid.cinema.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
