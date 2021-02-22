package ua.vedroid.cinema.service;

import ua.vedroid.cinema.model.Role;

public interface RoleService extends GenericService<Role> {
    Role getRoleByName(String roleName);
}
