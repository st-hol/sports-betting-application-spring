package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.OutcomeOdd;

import java.util.List;

public interface OutcomeOddService {
    List<OutcomeOdd> findAll();
    OutcomeOdd findById(Long id);
    OutcomeOdd save(OutcomeOdd outcomeOdd);
}