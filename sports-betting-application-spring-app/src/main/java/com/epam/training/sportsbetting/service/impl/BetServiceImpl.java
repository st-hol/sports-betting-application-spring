package com.epam.training.sportsbetting.service.impl;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.repository.BetRepository;
import com.epam.training.sportsbetting.service.BetService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Override
    public List<Bet> findAll() {
        return Lists.newArrayList(betRepository.findAll());
    }

    @Override
    public Bet findById(Long id) {
        return betRepository.findById(id).get();
    }

    @Override
    public Bet save(Bet bet) {
        return betRepository.save(bet);
    }

}
