package com.epam.training.sportsbetting.ui.util;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.domain.user.Player;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Deprecated
@AllArgsConstructor
@Slf4j
public class ApplicationView {

    private Locale currentLocale;
    private MessageSource messageSource;
    private SuggestedOutcomePrinter printer;

    public void printLine(String s) {
        log.info(s);
    }

    public void suggestOutcomeWithOddsTable(List<SportEvent> sportEvents) {
        if (sportEvents == null) {
            log.warn("No events.");
            return;
        }
        printer.printOutcomeOdds(sportEvents);
    }

    public void printResults(Player player, List<Wager> wagers) {
        printLine(messageSource.getMessage("results", new Object[]{}, currentLocale) + "\n");
        wagers.forEach(wager -> log.info(wager.toString()));
        printLine(messageSource.getMessage("your.new.balance", new Object[]{player.getBalance()}, currentLocale));
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public void setCurrentLocaleFromString(String stringLocale) {
        setCurrentLocale(new Locale(stringLocale));
    }
}
