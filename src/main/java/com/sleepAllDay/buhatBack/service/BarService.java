package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.dto.BarDto;
import com.sleepAllDay.buhatBack.models.Bar;

import java.util.List;
import java.util.Optional;

public interface BarService {
    List<BarDto> findAll();

    BarDto findById(Long id);

    void save(BarDto bar);

    void delete(BarDto bar);

    void deleteById(Long id);
}
