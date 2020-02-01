package com.epam.training.sportsbetting.ui.util;

import java.util.List;

import org.springframework.context.MessageSource;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.SportEvent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
@AllArgsConstructor
public class SuggestedOutcomePrinter {

    private MessageSource messageSource;
    private ApplicationView applicationView;

    void printOutcomeOdds(List<SportEvent> sportEvents) {
        if (sportEvents == null || sportEvents.isEmpty()) {
            log.warn("Empty sportEvents");
            return;
        }
        log.info(messageSource.getMessage("choose.bet", null, applicationView.getCurrentLocale()));

        int noOfOutcome = 0;
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        log.info(sportEvent.getTitle()
                                + ">>> NUMBER № " + noOfOutcome++ + ") (start: " + sportEvent.getStartDate() + ")"
                                + " Bet: " + bet.getDescription()
                                + " Outcome: " + outcome.getDescription()
                                + " Actual odd: " + outcomeOdd.getValue());
                    }
                }
            }
        }
    }

}
