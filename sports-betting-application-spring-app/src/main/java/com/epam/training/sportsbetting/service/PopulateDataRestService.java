package com.epam.training.sportsbetting.service;


import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.dto.BetDto;
import com.epam.training.sportsbetting.domain.dto.OutcomeDto;
import com.epam.training.sportsbetting.domain.dto.OutcomeOddDto;
import com.epam.training.sportsbetting.domain.dto.ProcessResultDto;
import com.epam.training.sportsbetting.domain.dto.SportEventDto;

public interface PopulateDataRestService {

    SportEventDto toSportEventDto(SportEvent sportEvent);

    SportEventDto populateSportEvent(SportEventDto sportEventDto);

    BetDto populateBetToSportEvent(BetDto betDto);

    OutcomeDto populateOutcomeToBet(OutcomeDto outcomeDto);

    OutcomeOddDto populateOutcomeOddToOutcome(OutcomeOddDto outcomeOddData);

    ProcessResultDto processResult(ProcessResultDto processResultDto);
}