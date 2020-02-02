package com.epam.training.sportsbetting.repository;

import com.epam.training.sportsbetting.domain.SportEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository extends CrudRepository<SportEvent, Long> {
}