package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.models.Bar;

import java.util.List;
import java.util.Optional;

public interface BarService {
    List<Bar> findAll();

    Optional<Bar> findById(Long id);

    void save(Bar bar);

    void save(Long id);

    void delete(Bar bar);

    void deleteById(Long id);
}
