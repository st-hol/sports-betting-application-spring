package com.epam.training.sportsbetting.domain.dto;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.type.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateWagerDto {
    private Long betId;
    private Long sportEventId;
    private Outcome outcome;
    private Currency currency;
    private BigDecimal amount;
}
