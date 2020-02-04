package com.epam.training.sportsbetting.domain.dto;

import java.math.BigDecimal;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.type.Currency;

import lombok.Data;

@Data
public class CreateWagerDto {
    private Outcome outcome;
    private Currency currency;
    private BigDecimal amount;
}
