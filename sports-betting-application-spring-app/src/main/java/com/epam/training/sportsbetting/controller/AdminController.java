package com.epam.training.sportsbetting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.sportsbetting.domain.dto.PlayerDto;
import com.epam.training.sportsbetting.domain.dto.SportEventDto;
import com.epam.training.sportsbetting.service.RestPopulateDataService;
import com.epam.training.sportsbetting.service.SportEventService;
import com.epam.training.sportsbetting.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestPopulateDataService restPopulateDataService;
    @Autowired
    private SportEventService sportEventService;

    @PostMapping("/event")
    public ResponseEntity<SportEventDto> createSportEvent(@RequestBody SportEventDto sportEventDto) {
        return new ResponseEntity<>(restPopulateDataService.populateSportEvent(sportEventDto), HttpStatus.CREATED);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerDto> findPlayer(@PathVariable Long id) {
        PlayerDto playerDto = userService.convertToPlayerDto(userService.findById(id));
        return new ResponseEntity<>(playerDto, HttpStatus.FOUND);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<SportEventDto> findEvent(@PathVariable Long id) {
        SportEventDto sportEventDto = restPopulateDataService.toSportEventDto(sportEventService.findById(id));
        return new ResponseEntity<>(sportEventDto, HttpStatus.FOUND);
    }

}
