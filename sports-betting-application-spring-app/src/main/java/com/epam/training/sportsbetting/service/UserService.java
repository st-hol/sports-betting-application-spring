package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.dto.PlayerRegisterDto;
import com.epam.training.sportsbetting.domain.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User findByUsername(String username);

    void registerUser(PlayerRegisterDto user);

    User obtainCurrentPrincipleUser();

}