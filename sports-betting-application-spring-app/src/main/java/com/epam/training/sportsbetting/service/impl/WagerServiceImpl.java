package com.epam.training.sportsbetting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.domain.user.User;
import com.epam.training.sportsbetting.repository.WagerRepository;
import com.epam.training.sportsbetting.service.WagerService;
import com.google.common.collect.Lists;


@Service
public class WagerServiceImpl implements WagerService {

    @Autowired
    private WagerRepository wagerRepository;

    @Override
    public List<Wager> findAll() {
        return Lists.newArrayList(wagerRepository.findAll());
    }

    @Override
    public Wager findById(Long id) {
        return wagerRepository.findById(id).get();
    }

    @Override
    public Wager save(Wager wager) {
        return wagerRepository.save(wager);
    }

    @Override
    public List<Wager> findAllByUser(User player) {
        return wagerRepository.findAllByPlayer(player);
    }

    @Override
    public void deleteById(Long idWager) {
        wagerRepository.deleteById(idWager);
    }

}
