package com.epam.training.sportsbetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }



//    @Bean
//    public CommandLineRunner loadData(BettingDataPoolHolder bettingDataPoolHolder,
//                                      SportEventService sportEventService,
//                                      OutcomeOddService outcomeOddService,
//                                      OutcomeService outcomeService,
//                                      BetService betService) {
//        List<SportEvent> sportEvents = bettingDataPoolHolder.getSportEvents();
//        return args -> {
//           sportEvents.forEach(sportEventService::save);
////           outcomeOdds.forEach(outcomeOddService::save);
//        };
//    }
}
