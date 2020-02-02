package com.epam.training.sportsbetting.controller;


import com.epam.training.sportsbetting.domain.dto.PlayerRegisterDto;
import com.epam.training.sportsbetting.service.SecurityService;
import com.epam.training.sportsbetting.service.UserService;
import com.epam.training.sportsbetting.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new PlayerRegisterDto());
        return "common/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") PlayerRegisterDto userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("reg. form had errors. redirecting"); //todo show errors
            return "common/registration";
        }

        userService.registerUser(userForm);
        securityService.autoLoginAfterReg(userForm.getEmail(), userForm.getPasswordConfirm());

        log.info("user registered");
        return "redirect:/player/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "common/login";
    }

}
