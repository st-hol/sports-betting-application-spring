package com.epam.training.sportsbetting.domain.user;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.domain.type.Currency;
import com.epam.training.sportsbetting.domain.user.role.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Player extends User {
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private Currency currency;
    private LocalDate birth;

    @OneToMany(mappedBy = "player")
    @Cascade(CascadeType.ALL)
    private Set<Wager> wagers; //todo it was inmem

    @PrePersist
    void preInsert() {
        if (this.roles.isEmpty()) {
            Role role = new Role();
            role.setId(1L);
            role.setName("PLAYER");
            roles.add(role);
        }
    }
}
