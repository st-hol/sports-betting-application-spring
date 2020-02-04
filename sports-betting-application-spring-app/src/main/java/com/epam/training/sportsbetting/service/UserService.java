package com.epam.training.sportsbetting.service;


import java.util.List;

import com.epam.training.sportsbetting.domain.dto.CreateWagerDto;
import com.epam.training.sportsbetting.domain.dto.PlayerDto;
import com.epam.training.sportsbetting.domain.user.User;
import com.epam.training.sportsbetting.exception.NotEnoughBalanceException;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User findByUsername(String username);

    void registerUser(PlayerDto user);

    User obtainCurrentPrincipleUser();

    void updatePlayerInfo(PlayerDto user);

    void makeWager(CreateWagerDto wagerDto) throws NotEnoughBalanceException;
}