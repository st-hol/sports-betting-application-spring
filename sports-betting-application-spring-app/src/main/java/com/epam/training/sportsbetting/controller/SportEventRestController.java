//package com.epam.training.sportsbetting.controller;
//
//import javax.validation.Valid;
//
//import com.epam.training.sportsbetting.domain.Bet;
//import com.epam.training.sportsbetting.domain.Outcome;
//import com.epam.training.sportsbetting.domain.OutcomeOdd;
//import com.epam.training.sportsbetting.domain.SportEvent;
//import com.epam.training.sportsbetting.service.SportEventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.epam.training.sportsbetting.service.UserService;
//
//@RestController
//@RequestMapping("/rest")
//public class SportEventRestController {
//
//    @Autowired
//    private SportEventService sportEventService;
//
//    @PostMapping("/event")
//    public ResponseEntity<SportEvent> createSportEvent(@RequestBody @Valid SportEvent sportEvent) {
//        return new ResponseEntity<>(sportEventService.createSportEvent(sportEvent), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/bet")
//    public ResponseEntity<Bet> addBetToSportEvent(@RequestBody @Valid Bet betData) {
//        return new ResponseEntity<>(sportEventService.addBetToSportEvent(betData), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/outcome")
//    public ResponseEntity<Outcome> addOutcomeToBet(@RequestBody @Valid Outcome outcome) {
//        return new ResponseEntity<>(sportEventService.addOutcomeToBet(outcome), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/outcomeOdd")
//    public ResponseEntity<OutcomeOdd> addOutcomeOddToOutcome(@RequestBody @Valid OutcomeOdd outcomeOddData) {
//        return new ResponseEntity<>(sportEventService.addOutcomeOddToOutcome(outcomeOddData), HttpStatus.CREATED);
//    }
//
//
//}
