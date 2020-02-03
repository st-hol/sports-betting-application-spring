package com.epam.training.sportsbetting.service;


import java.util.List;

import com.epam.training.sportsbetting.domain.Bet;

public interface BetService {
    List<Bet> findAll();
    Bet findById(Long id);
    Bet save(Bet bet);

    void deleteAll();
}