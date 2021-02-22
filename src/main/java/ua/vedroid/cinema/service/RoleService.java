package ua.vedroid.cinema.service;

import ua.vedroid.cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
