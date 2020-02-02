package com.epam.training.sportsbetting.domain.dto;

import com.epam.training.sportsbetting.domain.type.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PlayerRegisterDto {
    private Long id;
    private String email;
    private String password;
    private String passwordConfirm;
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private Currency currency;
    private LocalDate birth;
}
