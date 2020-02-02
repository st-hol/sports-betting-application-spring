package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.SportEvent;

import java.util.List;

public interface SportEventService {
    List<SportEvent> findAll();
    SportEvent findById(Long id);
    SportEvent save(SportEvent sportEvent);
}