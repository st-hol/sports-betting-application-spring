package com.epam.training.sportsbetting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.training.sportsbetting.domain.dto.PlayerDto;
import com.epam.training.sportsbetting.service.SportEventService;
import com.epam.training.sportsbetting.service.UserService;
import com.epam.training.sportsbetting.service.WagerService;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private UserService userService;
    @Autowired
    private WagerService wagerService;
    @Autowired
    private SportEventService sportEventService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        return "player/home";
    }


    @PutMapping("/home/update-info")
    public String updateInfo(PlayerDto playerDto) {
        userService.updatePlayerInfo(playerDto);
        return "redirect:/player/home";
    }

    @GetMapping("/wagers")
    public String wagers(Model model){
        model.addAttribute("wagers", wagerService.findAllByUser(userService.obtainCurrentPrincipleUser()));
        return "player/wagers";
    }


    @GetMapping("/events")
    public String events(Model model){
        model.addAttribute("events", sportEventService.findAll());
        return "player/events";
    }
}
