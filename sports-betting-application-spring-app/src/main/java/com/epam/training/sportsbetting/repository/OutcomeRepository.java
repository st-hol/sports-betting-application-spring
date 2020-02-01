package com.epam.training.sportsbetting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Outcome;


@Repository
public interface OutcomeRepository extends CrudRepository<Outcome, Long> {
}
