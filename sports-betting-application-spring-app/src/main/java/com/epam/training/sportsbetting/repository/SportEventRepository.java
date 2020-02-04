package com.epam.training.sportsbetting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;

@Repository
public interface SportEventRepository extends CrudRepository<SportEvent, Long> {

    //todo why join fetch does not work
    @Query("select sp from SportEvent sp " +
            "inner join Bet b on b.sportEvent = sp " +
            "inner join Outcome o on o.bet = b " +
            "inner join OutcomeOdd od on od.outcome = o " +
            "inner join Wager w on w.outcomeOdd = od " +
            "where w = :wager")
    Optional<SportEvent> findByWager(@Param("wager") Wager wager);
}