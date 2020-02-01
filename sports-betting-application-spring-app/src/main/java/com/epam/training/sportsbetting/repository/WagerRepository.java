package com.epam.training.sportsbetting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.sportsbetting.domain.user.User;


@Repository
public interface WagerRepository extends CrudRepository<User, Long> {
}
