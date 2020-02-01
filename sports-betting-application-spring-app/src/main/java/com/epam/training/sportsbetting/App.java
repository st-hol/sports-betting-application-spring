package com.epam.training.sportsbetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.service.impl.ApplicationService;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ApplicationService applicationService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        applicationService.chooseLocale();
        Player player = applicationService.obtainPlayerData();
        applicationService.processBetting(player);
    }

}
