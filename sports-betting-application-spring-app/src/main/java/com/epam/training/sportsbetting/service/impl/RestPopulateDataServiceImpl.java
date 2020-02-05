package com.epam.training.sportsbetting.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.epam.training.sportsbetting.builder.SportEventBuilder;
import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.dto.BetDto;
import com.epam.training.sportsbetting.domain.dto.OutcomeDto;
import com.epam.training.sportsbetting.domain.dto.OutcomeOddDto;
import com.epam.training.sportsbetting.domain.dto.SportEventDto;
import com.epam.training.sportsbetting.service.BetService;
import com.epam.training.sportsbetting.service.OutcomeOddService;
import com.epam.training.sportsbetting.service.OutcomeService;
import com.epam.training.sportsbetting.service.RestPopulateDataService;
import com.epam.training.sportsbetting.service.SportEventService;

@Service
public class RestPopulateDataServiceImpl implements RestPopulateDataService {


    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private OutcomeOddService outcomeOddService;

    @Autowired
    private BetService betService;

    @Autowired
    private SportEventService sportEventService;

    @Override
    public SportEventDto populateSportEvent(SportEventDto sportEventDto) {

        final SportEvent sportEvent = toSportEvent(sportEventDto);
        sportEventService.save(sportEvent);
        sportEventDto.setId(sportEvent.getId());
        if (!CollectionUtils.isEmpty(sportEventDto.getBets())) {
            sportEventDto.getBets().forEach(bet -> bet.setSportEventId(sportEventDto.getId()));
            sportEventDto.getBets().forEach(this::populateBetToSportEvent);
        }
        return sportEventDto;
    }

    @Override
    public BetDto populateBetToSportEvent(BetDto betDto) {
        final Bet bet = toBet(betDto);
        betService.save(bet);
        betDto.setId(bet.getId());
        if (!CollectionUtils.isEmpty(betDto.getOutcomes())) {
            betDto.getOutcomes().forEach(outcomeData -> outcomeData.setBetId(bet.getId()));
            betDto.getOutcomes().forEach(this::populateOutcomeToBet);
        }
        return betDto;
    }

    @Override
    public OutcomeDto populateOutcomeToBet(OutcomeDto outcomeDto) {
        final Outcome outcome = toOutcome(outcomeDto);
        outcomeService.save(outcome);
        outcomeDto.setId(outcome.getId());
        if (!CollectionUtils.isEmpty(outcomeDto.getOutcomeOdds())) {
            outcomeDto.getOutcomeOdds().forEach(outcomeOddDto -> outcomeOddDto.setOutcomeId(outcome.getId()));
            outcomeDto.getOutcomeOdds().forEach(this::populateOutcomeOddToOutcome);
        }
        return outcomeDto;
    }

    @Override
    public OutcomeOddDto populateOutcomeOddToOutcome(OutcomeOddDto outcomeOddData) {
        final OutcomeOdd outcomeOdd = toOutcomeOdd(outcomeOddData);
        outcomeOddService.save(outcomeOdd);
        outcomeOddData.setId(outcomeOdd.getId());
        return outcomeOddData;
    }

    @Override
    public SportEventDto toSportEventDto(SportEvent sportEvent) {
        SportEventDto sportEventDto = new SportEventDto();
        BeanUtils.copyProperties(sportEvent, sportEventDto);
        return sportEventDto;
    }

    private SportEvent toSportEvent(SportEventDto sportEventDto) {
        SportEventBuilder sportEventBuilder = new SportEventBuilder()
                .setId(sportEventDto.getId())
                .setTitle(sportEventDto.getTitle())
                .setStartDate(sportEventDto.getStartDate())
                .setEndDate(sportEventDto.getEndDate());
        if (sportEventDto.getEventType() == SportEventDto.EventType.FOOTBALL_EVENT) {
            return sportEventBuilder.buildFootballSportEvent();
        } else {
            return sportEventBuilder.buildTennisSportEvent();
        }
    }

    private Bet toBet(BetDto betDto) {
        Bet bet = new Bet();
        BeanUtils.copyProperties(betDto, bet, "outcomes", "sportEventId");
        bet.setSportEvent(sportEventService.findById(betDto.getSportEventId()));
        return bet;
    }

    private Outcome toOutcome(OutcomeDto outcomeDto) {
        Outcome outcome = new Outcome();
        BeanUtils.copyProperties(outcomeDto, outcome, "outcomeOdds", "betId");
        outcome.setBet(betService.findById(outcomeDto.getBetId()));
        return outcome;
    }

    private OutcomeOdd toOutcomeOdd(OutcomeOddDto outcomeOddDto) {
        OutcomeOdd outcomeOdd = new OutcomeOdd();
        BeanUtils.copyProperties(outcomeOddDto, outcomeOdd, "outcomeId");
        outcomeOdd.setOutcome(outcomeService.findById(outcomeOddDto.getOutcomeId()));
        return outcomeOdd;
    }

}
