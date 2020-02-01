package com.epam.training.sportsbetting.domain.user;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.domain.type.Currency;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Player extends User {
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private Currency currency;
    private LocalDate birth;

    @OneToMany(mappedBy = "player")
    @Cascade(CascadeType.ALL)
    private Set<Wager> wagers; //todo it was inmem
}
