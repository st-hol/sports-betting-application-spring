package com.epam.training.sportsbetting.service.impl;

import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.repository.SportEventRepository;
import com.epam.training.sportsbetting.service.SportEventService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SportEventServiceImpl implements SportEventService {

    @Autowired
    private SportEventRepository sportEventRepository;

    @Override
    public List<SportEvent> findAll() {
        return Lists.newArrayList(sportEventRepository.findAll());
    }

    @Override
    public SportEvent findById(Long id) {
        return sportEventRepository.findById(id).get();
    }

    @Override
    public SportEvent save(SportEvent sportEvent) {
        return sportEventRepository.save(sportEvent);
    }

}
