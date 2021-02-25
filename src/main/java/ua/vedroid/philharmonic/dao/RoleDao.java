package ua.vedroid.philharmonic.dao;

import java.util.Optional;
import ua.vedroid.philharmonic.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
