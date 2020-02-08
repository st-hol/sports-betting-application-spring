package com.epam.training.sportsbetting.configuration;

import com.epam.training.sportsbetting.db.BettingDataPoolHolder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Random;
import java.util.Scanner;


@Configuration
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public BettingDataPoolHolder bettingDataPoolHolder() {
        return new BettingDataPoolHolder();
    }
}
