package com.epam.training.sportsbetting.repository;

import com.epam.training.sportsbetting.domain.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
}
