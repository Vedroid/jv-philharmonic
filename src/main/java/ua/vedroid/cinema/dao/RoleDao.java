package ua.vedroid.cinema.dao;

import java.util.Optional;
import ua.vedroid.cinema.model.Role;

public interface RoleDao extends GenericDao<Role> {
    Optional<Role> getRoleByName(String roleName);
}
