package com.epam.training.sportsbetting.service.impl;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.repository.OutcomeRepository;
import com.epam.training.sportsbetting.service.OutcomeService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OutcomeServiceImpl implements OutcomeService {

    @Autowired
    private OutcomeRepository outcomeRepository;

    @Override
    public List<Outcome> findAll() {
        return Lists.newArrayList(outcomeRepository.findAll());
    }

    @Override
    public Outcome findById(Long id) {
        return outcomeRepository.findById(id).get();
    }

    @Override
    public Outcome save(Outcome outcome) {
        return outcomeRepository.save(outcome);
    }

}
