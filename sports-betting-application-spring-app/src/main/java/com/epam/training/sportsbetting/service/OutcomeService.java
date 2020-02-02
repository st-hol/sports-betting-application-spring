package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.Outcome;

import java.util.List;

public interface OutcomeService {
    List<Outcome> findAll();
    Outcome findById(Long id);
    Outcome save(Outcome outcome);
}