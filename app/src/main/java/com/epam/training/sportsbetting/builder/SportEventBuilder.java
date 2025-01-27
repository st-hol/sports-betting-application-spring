
package com.epam.training.sportsbetting.builder;


import java.time.LocalDateTime;
import java.util.List;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.FootballSportEvent;
import com.epam.training.sportsbetting.domain.Result;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.TennisSportEvent;


public class SportEventBuilder {

    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets;
    private Result result;

    public SportEventBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SportEventBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SportEventBuilder setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public SportEventBuilder setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public SportEventBuilder setBets(List<Bet> bets) {
        this.bets = bets;
        return this;
    }

    public SportEventBuilder setResult(Result result) {
        this.result = result;
        return this;
    }

    public TennisSportEvent buildTennisSportEvent() {
        TennisSportEvent sportEvent = new TennisSportEvent();
        setFields(sportEvent);
        return sportEvent;
    }

    public FootballSportEvent buildFootballSportEvent() {
        FootballSportEvent sportEvent = new FootballSportEvent();
        setFields(sportEvent);
        return sportEvent;
    }

    private void setFields(SportEvent sportEvent) {
        sportEvent.setId(id);
        sportEvent.setTitle(title);
        sportEvent.setStartDate(startDate);
        sportEvent.setEndDate(endDate);
        sportEvent.setBets(bets);
        sportEvent.setResult(result);
    }
}
