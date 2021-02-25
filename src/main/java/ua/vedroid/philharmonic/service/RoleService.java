package ua.vedroid.philharmonic.service;

import ua.vedroid.philharmonic.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
