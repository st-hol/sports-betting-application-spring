package com.epam.training.sportsbetting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.Result;


@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
}
