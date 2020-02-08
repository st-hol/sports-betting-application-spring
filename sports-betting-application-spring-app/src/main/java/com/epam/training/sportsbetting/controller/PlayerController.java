package com.epam.training.sportsbetting.controller;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.dto.CreateWagerDto;
import com.epam.training.sportsbetting.domain.dto.PlayerDto;
import com.epam.training.sportsbetting.exception.EventAlreadyStartedException;
import com.epam.training.sportsbetting.exception.NotEnoughBalanceException;
import com.epam.training.sportsbetting.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private UserService userService;
    @Autowired
    private WagerService wagerService;
    @Autowired
    private SportEventService sportEventService;
    @Autowired
    private BetService betService;
    @Autowired
    private OutcomeService outcomeService;


    @GetMapping({"/home", "/"})
    public String home(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        return "player/home";
    }


    @PutMapping("/home/update-info")
    public String updateUserInfo(PlayerDto playerDto) {
        userService.updatePlayerInfo(playerDto);
        return "redirect:/player/home";
    }

    @GetMapping("/wagers")
    public String listAllWagers(Model model) {
        model.addAttribute("wagers", wagerService.findAllByUser(userService.obtainCurrentPrincipleUser()));
        return "player/wagers";
    }

    @GetMapping("/events")
    public String listAllEvents(Model model) {
        model.addAttribute("events", sportEventService.findAll());
        return "player/events";
    }

    @GetMapping("/bets")
    public String listAllBetsByEvent(Model model,
                                     @RequestParam(value = "eventId") Long eventId) {
        SportEvent sportEvent = sportEventService.findById(eventId);
        model.addAttribute("event", sportEvent);
        model.addAttribute("bets", betService.findAllBySportEvent(sportEvent));
        return "player/bets";
    }

    @GetMapping("/wager")
    public String formWager(Model model,
                            @RequestParam(value = "betId") Long betId,
                            @RequestParam(value = "eventId") Long eventId) {
        Bet bet = betService.findById(betId);
        model.addAttribute("event", sportEventService.findById(eventId));
        model.addAttribute("bet", bet);
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("outcomes", outcomeService.findAllByBet(bet));
        model.addAttribute("wagerForm", new CreateWagerDto());
        return "/player/new-wager";
    }

    @PostMapping("/wager")
    public String createWager(@ModelAttribute("wagerForm") CreateWagerDto wagerDto) throws NotEnoughBalanceException {
        userService.makeWager(wagerDto);
        return "redirect:/player/wagers";
    }

    @DeleteMapping("/wager/{idWager}")
    public String deleteWager(@PathVariable Long idWager) throws EventAlreadyStartedException {
        wagerService.deleteById(idWager);
        return "redirect:/player/wagers";
    }

    @ExceptionHandler(NotEnoughBalanceException.class)
    public String handleNotEnoughBalanceException(Model model, Exception exception) {
        log.error("Not enough money for wager: {}", exception.getMessage());
        model.addAttribute("notEnoughMoney", true);
        CreateWagerDto requestForm = ((NotEnoughBalanceException) exception).getWagerDto();
        Long betId = requestForm.getBetId();
        Long sportEventId = requestForm.getSportEventId();
        return formWager(model, betId, sportEventId);
    }

    @ExceptionHandler(EventAlreadyStartedException.class)
    public String handleEventAlreadyStartedException(Model model, Exception exception) {
        log.error("Event is already started. Can not delete wager. {}", exception.getMessage());
        model.addAttribute("eventAlreadyStarted", true);
        return listAllWagers(model);
    }

}
