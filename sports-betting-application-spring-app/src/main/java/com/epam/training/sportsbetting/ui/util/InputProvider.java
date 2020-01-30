package com.epam.training.sportsbetting.ui.util;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import com.epam.training.sportsbetting.domain.type.TypeEnum;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class InputProvider {

    private Scanner scanner;

    public String readWithScanner() {
        return scanner.next();
    }

    public BigDecimal readBigDecimal() {
        while (!scanner.hasNextBigDecimal()) {
            scanner.next();
            log.error("Wrong format for number: please try again: ");
        }
        return scanner.nextBigDecimal();
    }

    public int readOrQuit() {
        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            log.error("User input failed. Value '0' was set", e);
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    public <E extends TypeEnum> E readStringForEnum(Class clazz) {
        while (true) {
            String inputString = scanner.nextLine().toUpperCase();
            Optional foundValue = TypeEnum.findOptionalEnumValue(clazz, inputString);
            if (foundValue.isPresent()) {
                return (E) foundValue.get();
            } else {
                log.error("You entered invalid value! Try again:");
            }
        }
    }

}
