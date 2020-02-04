package com.epam.training.sportsbetting.controller;

import com.epam.training.sportsbetting.domain.dto.PlayerDto;
import com.epam.training.sportsbetting.domain.dto.SportEventDto;
import com.epam.training.sportsbetting.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public SportEventDto createSportEvent(){
        return null;
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerDto> player(@PathVariable Long id){
        PlayerDto playerDto = userService.convertToPlayerDto(userService.findById(id));
        return new ResponseEntity<>(playerDto, HttpStatus.FOUND);
    }

}
