package com.epam.training.sportsbetting.service;


import java.util.List;

import com.epam.training.sportsbetting.domain.Result;

public interface ResultService {
    List<Result> findAll();

    Result findById(Long id);

    Result save(Result result);

    void deleteAll();
}