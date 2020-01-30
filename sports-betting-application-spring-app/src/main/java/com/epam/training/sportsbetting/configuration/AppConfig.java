package com.epam.training.sportsbetting.configuration;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.epam.training.sportsbetting.db.BettingDataPoolHolder;
import com.epam.training.sportsbetting.service.ApplicationService;
import com.epam.training.sportsbetting.service.BettingService;
import com.epam.training.sportsbetting.ui.util.ApplicationView;
import com.epam.training.sportsbetting.ui.util.InputProvider;
import com.epam.training.sportsbetting.ui.util.SuggestedOutcomePrinter;


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
    public ApplicationService applicationService(MessageSource messageSource, ApplicationView applicationView,
                                                 InputProvider inputProvider, BettingService bettingService) {
        return new ApplicationService(messageSource, applicationView, inputProvider, bettingService);
    }

    @Bean
    public ApplicationView applicationView(@Lazy SuggestedOutcomePrinter printer, MessageSource messageSource) {
        return new ApplicationView(Locale.ENGLISH, messageSource, printer);
    }

    @Bean
    public SuggestedOutcomePrinter printer(MessageSource messageSource, ApplicationView applicationView) {
        return new SuggestedOutcomePrinter(messageSource, applicationView);
    }

    @Bean
    public InputProvider inputProvider(Scanner scanner) {
        return new InputProvider(scanner);
    }

    @Bean
    public BettingService bettingService(Random random, BettingDataPoolHolder bettingDataPoolHolder) {
        return new BettingService(bettingDataPoolHolder, random);
    }

    @Bean
    public BettingDataPoolHolder bettingDataPoolHolder() {
        return new BettingDataPoolHolder();
    }


}
