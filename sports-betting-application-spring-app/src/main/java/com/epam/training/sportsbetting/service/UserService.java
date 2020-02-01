package com.epam.training.sportsbetting.service;


import java.util.List;

import com.epam.training.sportsbetting.domain.user.User;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User findByUsername(String username);

    void registerUser(User user);

    User obtainCurrentPrincipleUser();

}