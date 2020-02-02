package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.Bet;

import java.util.List;

public interface BetService {
    List<Bet> findAll();
    Bet findById(Long id);
    Bet save(Bet bet);
}