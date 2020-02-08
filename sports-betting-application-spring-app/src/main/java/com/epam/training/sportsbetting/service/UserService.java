package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.dto.CreateWagerDto;
import com.epam.training.sportsbetting.domain.dto.PlayerDto;
import com.epam.training.sportsbetting.domain.user.User;
import com.epam.training.sportsbetting.exception.NotEnoughBalanceException;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User findByUsername(String username);

    void registerUser(PlayerDto user);

    User obtainCurrentPrincipleUser();

    void updatePlayerInfo(PlayerDto user);

    PlayerDto convertToPlayerDto(User user);

    void makeWager(CreateWagerDto wagerDto) throws NotEnoughBalanceException;

    List<User> findAllByOutcome(Outcome outcome);

}