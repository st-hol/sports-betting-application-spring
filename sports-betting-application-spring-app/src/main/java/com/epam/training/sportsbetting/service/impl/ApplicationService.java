package com.epam.training.sportsbetting.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;

import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.domain.type.LanguageType;
import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.ui.util.ApplicationView;
import com.epam.training.sportsbetting.ui.util.InputProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationService {

    private MessageSource messageSource;
    private ApplicationView applicationView;
    private InputProvider inputProvider;
    private BettingService bettingService;

    public void chooseLocale() {
        applicationView.printLine(messageSource.getMessage("choose.locale", null,
                applicationView.getCurrentLocale()));
        applicationView.setCurrentLocaleFromString(inputProvider.readStringForEnum(LanguageType.class).toString());
        applicationView.printLine(messageSource.getMessage("locale.set", null,
                applicationView.getCurrentLocale()));
    }

    public Player obtainPlayerData() {
        Player player = new Player();
        applicationView.printLine(messageSource.getMessage("ask.name", null,
                applicationView.getCurrentLocale()));
        player.setName(inputProvider.readWithScanner());
        applicationView.printLine(messageSource.getMessage("ask.balance", null,
                applicationView.getCurrentLocale()));
        player.setBalance(inputProvider.readBigDecimal());
        return player;
    }

    public void processBetting(Player player) {
        applicationView.printLine(messageSource.getMessage("welcome", new Object[]{player.getName()},
                applicationView.getCurrentLocale()));
        BigDecimal startBalance = player.getBalance();
        List<SportEvent> allAvailableEvents = bettingService.getSportEventsData();
        List<Wager> userWagers = new ArrayList<>(); //todo findAll

        while (checkPlayerHasMoney(player)) {
            applicationView.printLine(messageSource.getMessage("your.new.balance",
                    new Object[]{player.getBalance(), player.getCurrency()}, applicationView.getCurrentLocale()));
            suggestOutcomeWithOddsTable(allAvailableEvents);
            int choice = readOrQuit();
            if (choice == 0) {
                break; // quit command
            }
            placeWager(bettingService.findOutcomeOddByNumber(choice), player, userWagers);
        }

        gatherResults(userWagers, player, startBalance);
    }

    private void placeWager(OutcomeOdd outcomeOdd, Player player, List<Wager> userWagers) {
        while (true) {
            BigDecimal wagerAmount = readWagerAmount();
            BigDecimal playerBalance = player.getBalance();
            if (checkPlayerHasEnoughMoney(wagerAmount, player)) {
                player.setBalance(playerBalance.subtract(wagerAmount));
                Wager wager = bettingService.createWager(player, wagerAmount, outcomeOdd);
                userWagers.add(wager);
                break;
            }
            applicationView.printLine(messageSource.getMessage("not.enough.money",
                    new Object[]{player.getBalance().doubleValue()}, applicationView.getCurrentLocale()));
        }
    }

    private void gatherResults(List<Wager> userWagers, Player player, BigDecimal startBalance) {
        bettingService.generateResult(bettingService.getSportEventsData(),
                userWagers, player);
        applicationView.printResults(player, userWagers);
        BigDecimal totalWonSum = bettingService.calculateTotalWonSum(startBalance, player.getBalance());
        applicationView.printLine(messageSource.getMessage("you.have.won", new Object[]{totalWonSum.doubleValue()},
                applicationView.getCurrentLocale()));
    }

    private boolean checkPlayerHasMoney(Player player) {
        return player.getBalance().compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean checkPlayerHasEnoughMoney(BigDecimal wagerAmount, Player player) {
        return player.getBalance().compareTo(wagerAmount) >= 0;
    }

    private void suggestOutcomeWithOddsTable(List<SportEvent> sportEvents) {
        applicationView.suggestOutcomeWithOddsTable(sportEvents);
    }

    private int readOrQuit() {
        return inputProvider.readOrQuit();
    }

    private BigDecimal readWagerAmount() {
        applicationView.printLine(messageSource.getMessage("how.much.bet",
                new Object[]{}, applicationView.getCurrentLocale()));
        return inputProvider.readBigDecimal();
    }


}
