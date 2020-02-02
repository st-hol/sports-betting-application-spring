package com.epam.training.sportsbetting.service.impl;

import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.repository.OutcomeOddRepository;
import com.epam.training.sportsbetting.service.OutcomeOddService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OutcomeOddServiceImpl implements OutcomeOddService {

    @Autowired
    private OutcomeOddRepository outcomeOddRepository;

    @Override
    public List<OutcomeOdd> findAll() {
        return Lists.newArrayList(outcomeOddRepository.findAll());
    }

    @Override
    public OutcomeOdd findById(Long id) {
        return outcomeOddRepository.findById(id).get();
    }

    @Override
    public OutcomeOdd save(OutcomeOdd outcomeOdd) {
        return outcomeOddRepository.save(outcomeOdd);
    }

}
