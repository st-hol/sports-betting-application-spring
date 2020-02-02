package com.epam.training.sportsbetting.repository;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WagerRepository extends CrudRepository<Wager, Long> {

    List<Wager> findAllByPlayer(User player); // todo User?
}
