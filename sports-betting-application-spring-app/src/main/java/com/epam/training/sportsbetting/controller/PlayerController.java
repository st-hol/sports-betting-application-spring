package com.epam.training.sportsbetting.controller;

import com.epam.training.sportsbetting.service.SportEventService;
import com.epam.training.sportsbetting.service.UserService;
import com.epam.training.sportsbetting.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @PostMapping("/home/update-info")
    public String updateInfo(){
        //todo
        return "redirect:/home";
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
