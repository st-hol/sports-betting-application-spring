package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OutcomeOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;

    @ManyToOne
    private Outcome outcome;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime validFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime validUntil;

    @Override
    public String toString() {
        return "OutcomeOdd{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OutcomeOdd that = (OutcomeOdd) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(outcome, that.outcome) &&
                Objects.equals(validFrom, that.validFrom) &&
                Objects.equals(validUntil, that.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, outcome, validFrom, validUntil);
    }
}
