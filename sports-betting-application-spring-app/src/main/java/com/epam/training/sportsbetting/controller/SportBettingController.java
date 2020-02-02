//package com.epam.training.sportsbetting.controller;
//
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.epam.training.sportsbetting.service.UserService;
//import com.epam.training.sportsbetting.service.impl.BettingService;
//
//@Controller
//public class SportBettingController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private BettingService bettingService;
//
//    @RequestMapping("/login")
//    public String login(Model model,
//                        @RequestParam(required = false) String error,
//                        @RequestParam(required = false) String logout) {
//        model.addAttribute("error", Objects.nonNull(error));
//        model.addAttribute("logout", Objects.nonNull(logout));
//        return "login";
//    }
//
//
//    @RequestMapping("/")
//    public String rootRedirect() {
//        return "redirect:/home";
//    }
//
//
//}
