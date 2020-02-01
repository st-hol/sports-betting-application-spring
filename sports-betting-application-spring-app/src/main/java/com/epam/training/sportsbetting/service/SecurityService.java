package com.epam.training.sportsbetting.service;


import java.util.Set;

import ua.training.entities.Role;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLoginAfterReg(String username, String password);

    Set<Role> getLoggedUserRoles();
}
